import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../../providers/carts_provider.dart';

class CartSection extends StatefulWidget {
  const CartSection(
      {Key? key,
      required this.id,
      required this.title,
      required this.popupDetailId,
      required this.description,
      required this.price,
      required this.quantity})
      : super(key: key);

  final int id;
  final String title;
  final int popupDetailId;
  final String description;
  final double price;
  final int quantity;

  @override
  State<CartSection> createState() => _CartSectionState();
}

class _CartSectionState extends State<CartSection> {
  int _quantity = 0;

  void _addItemNumber(int value) {
    setState(() {
      if (_quantity > 0) {
        _quantity = _quantity + value;
        Provider.of<CartProvider>(context, listen: false)
            // .addOrRemoveItem(widget.id, value);
        .addOrRemoveItem(widget.id, widget.popupDetailId, value);
      }
    });
  }

  String _generateTitle() {
    String noodleType = '';
    if(widget.popupDetailId == 1) {
      noodleType = 'อุด้ง';
    } else if (widget.popupDetailId == 2) {
      noodleType = 'อุด้ง แบน';
    } else if (widget.popupDetailId == 3) {
      noodleType = 'ราเมง';
    }
    return '${widget.title.toString()} ${noodleType}';

  }

  @override
  Widget build(BuildContext context) {
    _quantity = widget.quantity;
    return Container(
      color: Colors.grey,
      height: 50,
      width: double.infinity,
      child: Row(
        children: [
          Expanded(
            flex: 1,
            child: Text(_generateTitle()),
          ),
          Expanded(
            flex: 1,
            child: Row(
              children: [
                TextButton(
                  onPressed: () => _addItemNumber(-1),
                  child: const Text("-"),
                ),
                Text(_quantity.toString()),
                TextButton(
                  onPressed: () => _addItemNumber(1),
                  child: const Text("+"),
                ),
              ],
            ),
          )
        ],
      ),
    );
  }
}
