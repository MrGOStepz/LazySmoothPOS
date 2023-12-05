import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../../models/product_model.dart';
import '../../providers/order_provider.dart';

class TabScreen extends StatelessWidget {
  final Function setState;
  final List<Product> productList;
  const TabScreen({required this.setState, required this.productList, Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    return Row(
      children: [
        TextButton(
          onPressed: () => setState(1),
          child: const Text('Table Screen'),
        ),
        TextButton(
          onPressed: () {
            Provider.of<OrderProvider>(context, listen: false).getSummaryToday(productList);
            setState(2);
            },
          child: const Text('Summary Screen'),
        ),
      ],
    );
  }
}
