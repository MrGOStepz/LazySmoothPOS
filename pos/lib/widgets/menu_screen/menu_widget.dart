import 'package:flutter/material.dart';
import 'package:pos/widgets/menu_screen/category/category_widget.dart';
import 'package:pos/widgets/menu_screen/menu_list_widget.dart';

class MenuWidget extends StatefulWidget {
  const MenuWidget({super.key});

  @override
  State<MenuWidget> createState() => _MenuWidgetState();
}

class _MenuWidgetState extends State<MenuWidget> {

  int _categoryId = 1;


  void _changeCategoryId(int categoryId) {
    setState(() {
      _categoryId = categoryId;
    });
  }

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Expanded(
          flex: 1,
          child: Text("Search"),
        ),
        Expanded(
          flex: 1,
          child: CategoryWidget(changeCategoryId: _changeCategoryId),
        ),
        Expanded(
          flex: 8,
          child: MenuListWidget(categoryId: _categoryId,),
        ),
      ],
    );
  }
}
