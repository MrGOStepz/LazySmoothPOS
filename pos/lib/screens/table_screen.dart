import 'package:flutter/material.dart';
import 'package:pos/widgets/table_screen/table_widget.dart';
import 'package:provider/provider.dart';

import '../../models/table_info_model.dart';
import '../../providers/tables_provider.dart';


class TableScreen extends StatelessWidget {
  const TableScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Row(
      children: [
        Expanded(
          flex: 8,
          child: TableWidget(),
        ),
        Expanded(
          flex: 2,
          child: Text("Order"),
        ),
      ],
    );
  }
}


// class TableScreen extends StatefulWidget {
//   const TableScreen({Key? key}) : super(key: key);
//
//   @override
//   State<TableScreen> createState() => _TableScreenState();
// }
//
// class _TableScreenState extends State<TableScreen> {
//   // late StompClient stompClient;
//
//   @override
//   void initState() {
//     super.initState();
//     List<TableInfo> tempTableInfo = [];
//     tempTableInfo.add(TableInfo(1, "1", "Free", 0));
//     tempTableInfo.add(TableInfo(2, "2", "Free", 0));
//     tempTableInfo.add(TableInfo(3, "3", "Free", 0));
//     tempTableInfo.add(TableInfo(4, "4", "Free", 0));
//     tempTableInfo.add(TableInfo(5, "5", "Free", 0));
//     tempTableInfo.add(TableInfo(6, "6", "Free", 0));
//     tempTableInfo.add(TableInfo(7, "7", "Free", 0));
//     tempTableInfo.add(TableInfo(8, "8", "Free", 0));
//     Provider.of<TableInfoProvider>(context, listen: false)
//         .setItems(tempTableInfo);
//
//     //
//     //   if(stompClient.connected == false) {
//     //     stompClient = StompClient(
//     //       config: StompConfig(
//     //         url:
//     //         'http://${GlobalConfiguration().get(
//     //             "server_endpoint")}/gs-guide-websocket',
//     //         onConnect: onConnect,
//     //         onWebSocketError: (dynamic error) => print(error.toString()),
//     //       ),
//     //     );
//     //     stompClient.activate();
//     //   }
//   }
//
//   //
//   // void onConnect(StompFrame frame) {
//   //   dynamic result;
//   //   stompClient.subscribe(
//   //       destination: '/topic/table',
//   //       callback: (frame) {
//   //         result = jsonDecode(frame.body!);
//   //         List<TableInfo> tempTableInfo = [];
//   //         for (var value in result) {
//   //           TableInfo tableInfo = TableInfo.fromJson(value);
//   //           tempTableInfo.add(tableInfo);
//   //         }
//   //         Provider.of<TableInfoProvider>(context, listen: false)
//   //             .setItems(tempTableInfo);
//   //       });
//   // }
//
//   @override
//   Widget build(BuildContext context) {
//
//
//
//   }
// }
