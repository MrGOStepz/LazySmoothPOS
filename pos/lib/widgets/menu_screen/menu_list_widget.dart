import 'package:flutter/material.dart';
import 'package:pos/models/product_model.dart';
import 'package:pos/widgets/menu_screen/menu_item_widget.dart';
import 'package:provider/provider.dart';

import '../../providers/product_provider.dart';

class MenuListWidget extends StatelessWidget {
  final int categoryId;

  const MenuListWidget({required this.categoryId, super.key});

  @override
  Widget build(BuildContext context) {
    final productProvider = Provider.of<ProductProvider>(context, listen: true);
    List<Product> productList = productProvider.items
        .where((element) => element.categoryInfoId == categoryId)
        .toList();
    SliverGridDelegate gridDelegate =
        const SliverGridDelegateWithMaxCrossAxisExtent(
      maxCrossAxisExtent: 200,
      childAspectRatio: 1,
      crossAxisSpacing: 20,
      mainAxisSpacing: 20,
    );
    return GridView.builder(
      gridDelegate: gridDelegate,
      itemCount: productList.length,
      itemBuilder: (ctx, i) => MenuItemWidget(
        product: productList[i],
      ),
    );
  }
}
