import 'package:flutter/material.dart';
import 'package:pos/screens/table_screen.dart';

import '../models/product_model.dart';
import '../widgets/summary_screen/summary_screen.dart';
import '../widgets/tap_screen/tab_widget.dart';

class MainScreen extends StatefulWidget {
  final List<Product> productList;
  const MainScreen({required this.productList, Key? key}) : super(key: key);

  @override
  State<MainScreen> createState() => _MainScreenState();
}

class _MainScreenState extends State<MainScreen> {
  int _state = 1;

  void _changeScreen(int state) {
    setState(() {
      _state = state;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Expanded(
          flex: 2,
          child: TabScreen(setState: _changeScreen, productList: widget.productList,  ),
        ),
        if (_state == 1)
          const Expanded(
            flex: 8,
            child: TableScreen(),
          )
        else
          const Expanded(
            flex: 8,
            child: SummaryScreen(),
          )
      ],
    );
  }
}
