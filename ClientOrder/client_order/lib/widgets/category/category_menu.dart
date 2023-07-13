import 'package:flutter/cupertino.dart';
import 'package:provider/provider.dart';

import '../../providers/categories_provider.dart';
import 'category_menu_item.dart';

class CategoryMenu extends StatelessWidget {
  final Function(int) selectCategory;

  const CategoryMenu({required this.selectCategory, Key? key})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    final category = Provider.of<CategoryProvider>(context, listen: false);

    return ListView(
      children: category.items
          .map((item) => CategoryMenuItem(
                key: ValueKey(item.id),
                selectCategory: selectCategory,
                category: item,
              ))
          .toList(),
    );
  }
}
