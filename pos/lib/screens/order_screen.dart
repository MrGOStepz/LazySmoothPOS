import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../models/product_model.dart';
import '../providers/order_provider.dart';
import '../widgets/order_item_widget.dart';

class OrderScreen extends StatefulWidget {
  final List<Product> productList;

  const OrderScreen({required this.productList, Key? key}) : super(key: key);

  @override
  State<OrderScreen> createState() => _OrderScreenState();
}

class _OrderScreenState extends State<OrderScreen> {
  String listItem = '';

  @override
  Widget build(BuildContext context) {
    return Consumer<OrderProvider>(
      builder: (ctx, order, _) => ListView.builder(
        itemCount: order.orderDetailItemLength,
        itemBuilder: (ctx, i) => OrderItemWidget(
          product: widget.productList,
          productId: order.orderDetailItems[i].productId,
          orderDetailId: order.orderDetailItems[i].orderDetailId,
          popupDetailId: order.orderDetailItems[i].popupDetailId,
          quantity: order.orderDetailItems[i].quantity,
        ),
      ),
      // builder: (ctx, order, _) => Text(
      //   order.getOrderDetailText(productList),
      //   style: TextStyle(fontSize: 20),
      // ),
    );
  }
}
