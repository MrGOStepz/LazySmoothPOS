import 'package:client_order/widgets/cart/amount_cart.dart';
import 'package:client_order/widgets/cart/send_order.dart';
import 'package:flutter/material.dart';

import '../table_seletion.dart';
import 'cart.dart';

class CartOverview extends StatefulWidget {
  const CartOverview({Key? key}) : super(key: key);

  @override
  State<CartOverview> createState() => _CartOverviewState();
}

class _CartOverviewState extends State<CartOverview> {
  String tableName = '0';

  final _titleController = TextEditingController();

  void _changeTableName(String tableSelected) {
    setState(() {
      tableName = tableSelected;
      _titleController.text = tableName;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Expanded(
          flex: 1,
          child: Text('รายการอาหาร'),
          // child: ChangeTable(changeTableName: _changeTableName, titleController: _titleController,),
        ),
        Expanded(
          flex: 7,
          child: CartMenu(),
        ),
        Expanded(
          flex: 1,
          child: Column(
            children: [
              AmountCartItem(),
              SendOrder(titleController: _titleController,),
            ],
          ),
        )
      ],
    );
  }
}
