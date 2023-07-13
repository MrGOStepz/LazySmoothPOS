import 'package:client_order/providers/carts_provider.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import 'cart_item.dart';

class CartMenu extends StatefulWidget {
  const CartMenu({Key? key}) : super(key: key);

  @override
  State<CartMenu> createState() => _CartMenuState();
}

class _CartMenuState extends State<CartMenu> {

  @override
  Widget build(BuildContext context) {
    final cartProvider = Provider.of<CartProvider>(context, listen: true);
    Size size = MediaQuery.of(context).size;
    if (cartProvider.itemCount == 0) {
      return const Text("กรุณาเลือกเมนู");
    } else {
      return Consumer<CartProvider>(
        builder: (ctx, cart, _) => ListView.builder(
          itemCount: cart.itemCount,
          itemBuilder: (ctx, i) => CartSection(
            id: cart.items.values.toList()[i].productId,
            popupDetailId: cart.items.values.toList()[i].popupDetailId,
            title: cart.items.values.toList()[i].name,
            description: cart.items.values.toList()[i].description,
            price: cart.items.values.toList()[i].price,
            quantity: cart.items.values.toList()[i].quantity,
          ),
        ),
      );
    }
  }
}
