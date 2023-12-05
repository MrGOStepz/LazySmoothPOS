import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../models/product_model.dart';
import '../providers/order_provider.dart';

class OrderItemWidget extends StatefulWidget {
  final List<Product> product;
  final int productId;
  final int orderDetailId;
  final int popupDetailId;
  int quantity = 0;

  OrderItemWidget(
      {required this.product,
      required this.productId,
        required this.orderDetailId,
      required this.popupDetailId,
      required this.quantity,
      Key? key})
      : super(key: key);

  @override
  State<OrderItemWidget> createState() => _OrderItemWidgetState();
}

class _OrderItemWidgetState extends State<OrderItemWidget> {
  double _price = 0;
  void _addItemNumber(int value) {
    setState(() {
      if (widget.quantity + value >= 0) {
        widget.quantity = widget.quantity + value;

        Provider.of<OrderProvider>(context, listen: false).addAndRemoveOrderItem(widget.orderDetailId, widget.quantity, _price);
      }
    });
  }

  String _getTitle() {
    String name = widget.product
        .firstWhere((element) => element.id == widget.productId)
        .name;
    return name;
  }

  String _getNoodleType() {
    String noodleType;
    if (widget.popupDetailId == 1) {
      noodleType = 'อุด้ง';
    } else if (widget.popupDetailId == 2) {
      noodleType = 'อุงด้งเส้นแบน';
    } else if (widget.popupDetailId == 3) {
      noodleType = 'ราเมง';
    } else {
      noodleType = '';
    }
    return noodleType;
  }

  double _calculatePrice(double productPrice) {
    double price = productPrice;
    if (widget.popupDetailId == 2) {
      price = (price * widget.quantity) + (widget.quantity * 20);
    } else {
      price *= widget.quantity;
    }
    _price = price;
    return price;
  }

  @override
  Widget build(BuildContext context) {
    final orderProvider = Provider.of<OrderProvider>(context, listen: false);
    return Container(
      color: Colors.grey,
      width: double.infinity,
      child: Row(
        children: [
          Expanded(
            flex: 1,
            child: Card(
              child: ListTile(
                title: Text(
                  _getTitle(),
                ),
                subtitle: Text(
                  _getNoodleType(),
                  style: const TextStyle(
                    fontSize: 15,
                    color: Colors.red,
                  ),
                ),
              ),
            ),
          ),
          Expanded(
            flex: 1,
            child: Row(
              children: [
                TextButton(
                  onPressed: () => _addItemNumber(-1),
                  child: const Text("-"),
                ),
                Text(widget.quantity.toString()),
                TextButton(
                  onPressed: () => _addItemNumber(1),
                  child: const Text("+"),
                ),
              ],
            ),
          ),
          Expanded(
            flex: 1,
            child: Text(
                '${_calculatePrice(orderProvider.getOrderDetailPriceById(widget.productId))}', style: const TextStyle(fontSize: 30),),
          ),
        ],
      ),
    );
  }
}
