import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../providers/order_provider.dart';
import '../services/web_socket.dart';

class PaidWidget extends StatefulWidget {
  const PaidWidget({Key? key}) : super(key: key);

  @override
  State<PaidWidget> createState() => _PaidWidgetState();
}

class _PaidWidgetState extends State<PaidWidget> {
  void _updateOrderPaid() {
   setState(() {
     Provider.of<OrderProvider>(context, listen: false).updateStatus();
     // Provider.of<OrderProvider>(context, listen: false).sendTableStatus();
   });
  }

  @override
  Widget build(BuildContext context) {

    // stompClient.activate();
    return InkWell(
      child:
      DecoratedBox(
        decoration: const BoxDecoration(color: Colors.grey),
        child: TextButton(
          onPressed: _updateOrderPaid,
          child: const Text('PAY'),
        ),
      ),
    );
  }
}
