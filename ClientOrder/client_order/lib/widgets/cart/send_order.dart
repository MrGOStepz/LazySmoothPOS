import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../../providers/carts_provider.dart';

class SendOrder extends StatefulWidget {
final TextEditingController titleController;
  const SendOrder({required this.titleController, Key? key}) : super(key: key);

  @override
  State<SendOrder> createState() => _SendOrderState();
}

class _SendOrderState extends State<SendOrder> {

  final _titleController = TextEditingController();
  late String tableName = '';
  void _changeTableName(String tableSelected) {
    setState(() {
      tableName = tableSelected;
      _titleController.text = tableName;
    });
  }
  void _sendOrder() {
    setState(() {
      Provider.of<CartProvider>(context, listen: false).sendToWebSocket(_titleController.text);
      Provider.of<CartProvider>(context, listen: false).sendTableStatus(_titleController.text);
      _titleController.text = "";
    });
  }

  @override
  Widget build(BuildContext context) {
    return TextButton(
      onPressed: () => showDialog<String>(
        context: context,
        builder: (BuildContext context) => AlertDialog(
          title: const Text('Confirm Order'),
          content: Column(
            children: [
              const Text('ถ้ากด Send แล้ว จะไม่สามารถยกเลิกได้'),
              TextField(
                  decoration: InputDecoration(labelText: 'Table Name'),
                  keyboardType: TextInputType.number,
                  controller: _titleController,
                  onSubmitted: (_) {
                    _changeTableName(_titleController.text);
                  }
              )
            ],
          ),
          actions: [
            TextButton(
              onPressed: () => Navigator.pop(context, 'Cancel'),
              child: const Text('Cancel'),
            ),
            TextButton(
              onPressed: () {
                Navigator.pop(context, 'Send');
                _sendOrder();
              },
              child: const Text('Send'),
            ),
          ],
        ),
      ),
      child: const Text("Send"),
    );
  }
}
