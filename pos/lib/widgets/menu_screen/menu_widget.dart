import 'package:flutter/material.dart';
import 'package:pos/widgets/menu_screen/category/category_widget.dart';

class MenuWidget extends StatefulWidget {
  const MenuWidget({super.key});

  @override
  State<MenuWidget> createState() => _MenuWidgetState();
}

class _MenuWidgetState extends State<MenuWidget> {
  @override
  Widget build(BuildContext context) {
    SliverGridDelegate gridDelegate =
        const SliverGridDelegateWithMaxCrossAxisExtent(
      maxCrossAxisExtent: 200,
      childAspectRatio: 3 / 2,
      crossAxisSpacing: 20,
      mainAxisSpacing: 20,
    );
    return Column(
      children: [
        Expanded(
          flex: 1,
          child: Text("Search"),
        ),
        Expanded(
          flex: 1,
          child: CategoryWidget(),
        ),
        Expanded(
          flex: 8,
          child: Text("ListMenu"),
        ),
      ],
    );
  }
}
