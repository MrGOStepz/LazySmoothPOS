import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../../providers/order_provider.dart';

class SummaryScreen extends StatelessWidget {
  const SummaryScreen({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    final orderProvider = Provider.of<OrderProvider>(context, listen:true);
    return SingleChildScrollView(
      child: SizedBox(
        width: double.infinity,
        child: SelectableText(
          orderProvider.getSummaryText,
          style: const TextStyle(fontSize: 20),
        ),
      ),
    );
  }
}
