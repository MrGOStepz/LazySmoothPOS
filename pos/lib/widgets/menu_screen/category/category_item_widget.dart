import 'package:flutter/material.dart';

class CategoryItemWidget extends StatelessWidget {
  final String name;
  final int categoryId;
  final Function changeCategoryId;

  const CategoryItemWidget(
      {required this.name,
      required this.categoryId,
      required this.changeCategoryId,
      super.key});

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      width: 100,
      child: Card(
        elevation: 5,
        margin: const EdgeInsets.symmetric(vertical: 5, horizontal: 5),
        child: InkWell(
          onTap: () => changeCategoryId(categoryId),
          child: Text(name),
        ),
      ),
    );
  }
}
