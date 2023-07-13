import 'dart:async';

import 'package:flutter/material.dart';
import 'package:shared_preferences/shared_preferences.dart';

class ChangeTable extends StatefulWidget {
  final Function changeTableName;
  final TextEditingController titleController;

  const ChangeTable(
      {required this.changeTableName, required this.titleController, Key? key})
      : super(key: key);

  @override
  State<ChangeTable> createState() => _ChangeTableState();
}

class _ChangeTableState extends State<ChangeTable> {
  final Future<SharedPreferences> _prefs = SharedPreferences.getInstance();
  late Future<String> _tableName;

  Future<void> _setTable() async {
    final SharedPreferences prefs = await _prefs;
    final String tableName = (prefs.getString('tableName') ?? 'Table');
    setState(() {
      _tableName = prefs.setString('tableName', tableName).then((bool success) {
        return tableName;
      });
    });
  }

  @override
  void initState() {
    super.initState();
    _tableName = _prefs.then((SharedPreferences prefs) {
      return prefs.getString('tableName') ?? 'Table';
    });
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        FutureBuilder<String>(
          future: _tableName,
          builder: (BuildContext context, AsyncSnapshot<String> snapshot) {
            switch (snapshot.connectionState) {
              case ConnectionState.none:
              case ConnectionState.waiting:
                return const CircularProgressIndicator();
              case ConnectionState.active:
              case ConnectionState.done:
                if (snapshot.hasError) {
                  return const Text('Error');
                } else {
                  return TextField(
                    decoration: InputDecoration(labelText: snapshot.data),
                    keyboardType: TextInputType.number,
                    controller: widget.titleController,
                    onSubmitted: (_) {
                      widget.changeTableName(widget.titleController.text);
                      _setTable();
                    },
                  );
                }
            }
          },
        ),
      ],
    );
    // return Column(
    //   children: ,
    //   )
    //     TextField(
    //       decoration: InputDecoration(labelText: _tableName),
    //       keyboardType: TextInputType.number,
    //       controller: widget.titleController,
    //       onSubmitted: (_) {
    //         widget.changeTableName(widget.titleController.text);
    //         _prefs.setString('tableName', widget.titleController.text);
    //       },
    //     )
    //   ],
    // );
  }
}
