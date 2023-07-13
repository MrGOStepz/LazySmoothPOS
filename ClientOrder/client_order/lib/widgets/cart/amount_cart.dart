import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../../providers/carts_provider.dart';

class AmountCartItem extends StatelessWidget {
  const AmountCartItem({ Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      child: Consumer<CartProvider>(
        builder: (_, cart, ch) => Text('Total: ${cart.totalAmount} bath')
      ),
    );
  }
}
