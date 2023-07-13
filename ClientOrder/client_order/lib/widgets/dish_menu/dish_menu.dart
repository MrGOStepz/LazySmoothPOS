import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../../models/product_model.dart';
import '../../providers/products_provider.dart';
import 'dish_menu_item.dart';

class DishMenu extends StatelessWidget {
  final int currentCategory;
  final int currentPage;

  DishMenu({Key? key, required this.currentCategory, required this.currentPage})
      : super(key: key);

  Widget generateExpanded(List<Product> productItems, int row, int column) {
    try {
      Product productItem = productItems
          .where((value) =>
              value.locationRow == row && value.locationColumn == column)
          .first;
      return ProductMenuItem(
        id: productItem.id,
        popupInfoId: productItem.popupInfoId,
        price: productItem.price,
        name: productItem.name,
        imagePath: productItem.imagePath,
      );
    } catch (e) {
      return const Text("");
    }
  }

  @override
  Widget build(BuildContext context) {
    final product = Provider.of<ProductProvider>(context, listen: false);
    var sizeScreen = MediaQuery.of(context).size;
    var itemHeight = sizeScreen.height;
    var itemWidth = sizeScreen.width / 2;
    List<Product> productItem =
        product.getProductsByCategoryAndPage(currentCategory, currentPage);

    return Container(
        width: double.infinity,
        height: itemHeight,
        child: Column(children: [
          Expanded(
            flex: 1,
            child: Row(
              children: [
                Expanded(flex: 1, child: generateExpanded(productItem, 1, 1)),
                Expanded(flex: 1, child: generateExpanded(productItem, 1, 2))
              ],
            ),
          ),
          Expanded(
              flex: 1,
              child: Row(
                children: [
                  Expanded(flex: 1, child: generateExpanded(productItem, 2, 1)),
                  Expanded(
                    flex: 1,
                    child: generateExpanded(productItem, 2, 2),
                  )
                ],
              )),
        ]));
  }
}
