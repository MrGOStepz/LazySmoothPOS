import 'package:flutter/material.dart';
import 'package:pos/models/category_model.dart';
import 'package:pos/providers/categories_provider.dart';
import 'package:provider/provider.dart';

class CategoryWidget extends StatelessWidget {
  const CategoryWidget({super.key});

  @override
  Widget build(BuildContext context) {
    final category = Provider.of<CategoryProvider>(context, listen: false);
    List<Category> categoryItem = category.items;
    // Set<int> pageNumber = products.getNumberOfPageByCategory(currentCategory);

    return ListView(
      scrollDirection: Axis.horizontal,
      children: pageNumber
          .map((e) =>
          MenuBarPage(
            key: ValueKey(e),
            page: e,
            tapMenubar: selectedMenubar,
          ))
          .toList(),
    );
    return Consumer(builder: builder)
  }
}
