import 'package:flutter/material.dart';
import 'package:pos/models/category_model.dart';
import 'package:pos/providers/categories_provider.dart';
import 'package:pos/widgets/menu_screen/category/category_item_widget.dart';
import 'package:provider/provider.dart';

class CategoryWidget extends StatelessWidget {
  final Function changeCategoryId;

  const CategoryWidget({required this.changeCategoryId, super.key});

  @override
  Widget build(BuildContext context) {
    final category = Provider.of<CategoryProvider>(context, listen: false);
    List<Category> categoryItem = category.items;

    return ListView.builder(
        padding: const EdgeInsets.all(5),
        scrollDirection: Axis.horizontal,
        itemCount: categoryItem.length,
        itemBuilder: (BuildContext context, int index) {
          return CategoryItemWidget(
            name: categoryItem[index].name,
            categoryId: categoryItem[index].id,
            changeCategoryId: changeCategoryId,
          );
        });
  }
}
