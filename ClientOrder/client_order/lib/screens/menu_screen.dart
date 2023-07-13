import 'package:flutter/material.dart';

import '../widgets/category/category_bar.dart';
import '../widgets/dish_menu/dish_menu.dart';

class MenuScreen extends StatefulWidget {
  final int currentCategorySelected;
  final int currentCategoryPageSelected;
  final Function(int) selectMenubar;
  static const routeName = '/menu-screen';

  const MenuScreen(
      {Key? key,
      required this.currentCategorySelected,
      required this.currentCategoryPageSelected,
      required this.selectMenubar})
      : super(key: key);

  @override
  State<MenuScreen> createState() => _MenuScreenState();
}

class _MenuScreenState extends State<MenuScreen> {
  int currentMenuId = 0;

  void selectMenuItem(int pageId, int menuId) {
    setState(() {
      currentMenuId = menuId;
    });
  }

  @override
  Widget build(BuildContext context) {
    var size = MediaQuery.of(context).size;

    return Column(
      children: [
        Container(
            alignment: Alignment.topCenter,
            width: double.infinity,
            height: size.height * 0.1,
            child: CategoryMenuBar(
              currentCategory: widget.currentCategorySelected,
              selectedMenubar: widget.selectMenubar,
            )),
        Container(
            alignment: Alignment.topCenter,
            width: double.infinity,
            height: size.height * 0.8,
            child: DishMenu(
              currentCategory: widget.currentCategorySelected,
              currentPage: widget.currentCategoryPageSelected,
            ))
      ],
    );
  }
}
