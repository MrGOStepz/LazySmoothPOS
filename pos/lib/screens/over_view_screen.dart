import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../models/product_model.dart';
import '../providers/order_provider.dart';
import '../providers/product_provider.dart';
import '../providers/tables_provider.dart';
import '../widgets/paid_widget.dart';
import 'main_screen.dart';
import 'order_screen.dart';

class OverViewScreen extends StatefulWidget {
  const OverViewScreen({Key? key}) : super(key: key);

  @override
  State<OverViewScreen> createState() => _OverViewScreenState();
}

class _OverViewScreenState extends State<OverViewScreen> {
  var _isInit = true;
  final _isLoading = false;

  int currentCategorySelected = 1;
  int currentCategoryPageSelected = 1;

  List<Product> productList = [];

  final double _totalPrice = 0;

  @override
  void initState() {
    //
    // if (_isInit) {
    //   //   setState(() {
    //   //     _isLoading = true;
    //   //   });
    //   //   Provider.of<Products>(context).fetchAndSetProducts().then((_) {
    //   //     setState(() {
    //   //       _isLoading = false;
    //   //     });
    //   //   });
    //   Provider.of<ProductProvider>(context, listen: false).fetchAndSetProducts();
    //
    // }
    // _isInit = false;
    super.initState();
  }

  @override
  void didChangeDependencies() {
    if (_isInit) {
      //   setState(() {
      //     _isLoading = true;
      //   });
      //   Provider.of<Products>(context).fetchAndSetProducts().then((_) {
      //     setState(() {
      //       _isLoading = false;
      //     });
      //   });
      Provider.of<ProductProvider>(context, listen: true).fetchAndSetProducts();
      Provider.of<TableInfoProvider>(context, listen: true)
          .fetchAndSetTableInfo();
    }
    _isInit = false;

    productList = Provider.of<ProductProvider>(context, listen: true).items;
    super.didChangeDependencies();
  }

  void _updateOrderItem() {
    debugPrint('Hello');
    setState(() {
      Provider.of<OrderProvider>(context, listen: false).updateItem();
    });
  }

  @override
  Widget build(BuildContext context) {
    final orderProvider = Provider.of<OrderProvider>(context, listen: true);
    return Scaffold(
      body: SafeArea(
        child: Row(
          children: [
            Expanded(
              flex: 7,
              child: SizedBox(
                width: double.infinity,
                height: MediaQuery.of(context).size.height,
                child: MainScreen(
                  productList: productList,
                ),
              ),
            ),
            Expanded(
              flex: 3,
              child: SizedBox(
                width: double.infinity,
                height: MediaQuery.of(context).size.height,
                child: Column(
                  children: [
                    Expanded(
                      flex: 8,
                      child: OrderScreen(
                        productList: productList,
                      ),
                    ),
                    Expanded(
                      flex: 1,
                      child: Row(
                        children: [
                          Expanded(
                            flex: 2,
                            child: Center(
                                child: Text(
                              'ราคา ${orderProvider.totalPrice}',
                              style: const TextStyle(fontSize: 40),
                            )),
                          ),
                          Expanded(
                            flex: 1,
                            child: Center(
                              child: TextButton(
                                onPressed: () {
                                  orderProvider.updateItem();
                                  // _updateOrderItem
                                },
                                child: const Text('Update'),
                              ),
                            ),
                          ),
                        ],
                      ),
                    ),
                    const Expanded(
                        flex: 1,
                        child: SizedBox(
                            width: double.infinity, child: PaidWidget()))
                  ],
                ),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
