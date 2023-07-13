import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../../providers/products_provider.dart';
import 'category_bar_item.dart';

class CategoryMenuBar extends StatelessWidget {
  final int currentCategory;
  final Function(int) selectedMenubar;

  const CategoryMenuBar(
      {Key? key, required this.selectedMenubar, required this.currentCategory})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    final products = Provider.of<ProductProvider>(context, listen: false);
    Set<int> pageNumber = products.getNumberOfPageByCategory(currentCategory);

    return ListView(
      scrollDirection: Axis.horizontal,
      children: pageNumber
          .map((e) => MenuBarPage(
                key: ValueKey(e),
                page: e,
                tapMenubar: selectedMenubar,
              ))
          .toList(),
    );
  }
}
