import 'package:flutter/material.dart';

class NoodleTypeItem extends StatefulWidget {
  const NoodleTypeItem({Key? key}) : super(key: key);

  @override
  State<NoodleTypeItem> createState() => _NoodleTypeItemState();
}

enum NoodleType { thin, flat, white }

class _NoodleTypeItemState extends State<NoodleTypeItem> {
  NoodleType? _noodleType = NoodleType.thin;

  Future<void> _displayTextInputDialog(BuildContext context) async {
    return showDialog(
      context: context,
      builder: (context) {
        return AlertDialog(
          title: Text('เลือกชนิดเส้น'),
          content: StatefulBuilder(
            builder: (BuildContext context, StateSetter setState) {
              return Column(
                children: [
                  ListTile(
                    title: const Text('Thin'),
                    leading: Radio<NoodleType>(
                      value: NoodleType.thin,
                      groupValue: _noodleType,
                      onChanged: (NoodleType? value) {
                        setState(() {
                          _noodleType = value;
                        });
                      },
                    ),
                  ),
                  ListTile(
                    title: const Text('Flat'),
                    leading: Radio<NoodleType>(
                      value: NoodleType.flat,
                      groupValue: _noodleType,
                      onChanged: (NoodleType? value) {
                        setState(() {
                          _noodleType = value;
                        });
                      },
                    ),
                  ),
                  ListTile(
                    title: const Text('White'),
                    leading: Radio<NoodleType>(
                      value: NoodleType.white,
                      groupValue: _noodleType,
                      onChanged: (NoodleType? value) {
                        setState(() {
                          _noodleType = value;
                        });
                      },
                    ),
                  ),
                ],
              );
            }
          ),
          actions: [
            TextButton(
              onPressed: () {
                setState(() {
                  Navigator.pop(context);
                });
              },
              child: Text("Cancel"),
            ),
            TextButton(
              onPressed: () {
                setState(() {
                  // codeDialog = valueText;
                  Navigator.pop(context);
                });
              },
              child: Text("Ok"),
            ),
          ],
        );
      },
    );
  }

  @override
  Widget build(BuildContext context) {
    return TextButton(
      onPressed: () => _displayTextInputDialog(context),
      child: Text('Test'),
    );
  }
}
