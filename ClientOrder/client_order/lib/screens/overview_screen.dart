import 'package:client_order/providers/categories_provider.dart';
import 'package:client_order/widgets/cart/cart.dart';
import 'package:client_order/widgets/cart/cart_overview.dart';
import 'package:client_order/widgets/cart/send_order.dart';
import 'package:client_order/widgets/table_seletion.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../models/product_model.dart';
import '../providers/products_provider.dart';
import '../widgets/cart/cart_item.dart';
import '../widgets/category/category_menu.dart';
import '../services/web_socket.dart';
import 'menu_screen.dart';

class OrderOverViewScreen extends StatefulWidget {
  const OrderOverViewScreen({Key? key}) : super(key: key);

  @override
  State<OrderOverViewScreen> createState() => _OrderOverViewScreenState();
}

class _OrderOverViewScreenState extends State<OrderOverViewScreen> {
  var _isInit = true;
  var _isLoading = false;

  int currentCategorySelected = 1;
  int currentCategoryPageSelected = 1;

  @override
  void initState() {
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

      Provider.of<CategoryProvider>(context).fetchAndSetCategory();
      Provider.of<ProductProvider>(context).fetchAndSetProducts();
    }
    _isInit = false;
    super.didChangeDependencies();
  }

  void selectCategoryMenu(int categoryId) {
    setState(() {
      currentCategorySelected = categoryId;
      currentCategoryPageSelected = 1;
    });
  }

  void selectMenuBar(int pageId) {
    setState(() {
      currentCategoryPageSelected = pageId;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: SafeArea(
        child: Row(
          children: [
            Expanded(
              flex: 2,
              child: Container(
                alignment: Alignment.topCenter,
                child: CategoryMenu(
                  selectCategory: selectCategoryMenu,
                ),
              ),
            ),
            Expanded(
              flex: 4,
              child: MenuScreen(
                currentCategorySelected: currentCategorySelected,
                currentCategoryPageSelected: currentCategoryPageSelected,
                selectMenubar: selectMenuBar,
              ),
            ),
            Expanded(
              flex: 2,
              child: Container(
                alignment: Alignment.topCenter,
                width: double.infinity,
                height: MediaQuery.of(context).size.height,
                // child: Text("Test"),
                child: const CartOverview(),
              ),
            ),
          ],
        ),
      ),
    );
  }
}
