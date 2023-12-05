import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:global_configuration/global_configuration.dart';
import 'package:provider/provider.dart';
import 'package:stomp_dart_client/stomp.dart';
import 'package:stomp_dart_client/stomp_config.dart';
import 'package:stomp_dart_client/stomp_frame.dart';

import '../../models/table_info_model.dart';
import '../../providers/tables_provider.dart';
import 'table_item_widget.dart';

class TableScreen extends StatefulWidget {
  const TableScreen({Key? key}) : super(key: key);

  @override
  State<TableScreen> createState() => _TableScreenState();
}

class _TableScreenState extends State<TableScreen> {
  late StompClient stompClient;

  @override
  void initState() {
    super.initState();

    stompClient = StompClient(
      config: StompConfig(
        url:
            'http://${GlobalConfiguration().get("server_endpoint")}/gs-guide-websocket',
        onConnect: onConnect,
        onWebSocketError: (dynamic error) => print(error.toString()),
      ),
    );
    stompClient.activate();
  }

  void onConnect(StompFrame frame) {
    dynamic result;
    stompClient.subscribe(
        destination: '/topic/table',
        callback: (frame) {
          result = jsonDecode(frame.body!);
          List<TableInfo> tempTableInfo = [];
          for (var value in result) {
            TableInfo tableInfo = TableInfo.fromJson(value);
            tempTableInfo.add(tableInfo);
          }
          Provider.of<TableInfoProvider>(context, listen: false)
              .setItems(tempTableInfo);
        });
  }

  @override
  Widget build(BuildContext context) {
    SliverGridDelegate gridDelegate =
        const SliverGridDelegateWithMaxCrossAxisExtent(
      maxCrossAxisExtent: 200,
      childAspectRatio: 3 / 2,
      crossAxisSpacing: 20,
      mainAxisSpacing: 20,
    );
    return Consumer<TableInfoProvider>(
      builder: (ctx, table, _) => GridView.builder(
        gridDelegate: gridDelegate,
        itemCount: table.items.length,
        itemBuilder: (ctx, i) => TableItemWidget(
          tableName: table.items[i].name,
          status: table.items[i].status,
        ),
      ),
    );
  }
}
