import 'package:flutter/material.dart';

class MenuBarPage extends StatelessWidget {
  final int page;
  final Function(int) tapMenubar;

  const MenuBarPage({Key? key, required this.page, required this.tapMenubar})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      width: 100,
      child: Card(
        elevation: 5,
        margin: const EdgeInsets.symmetric(vertical: 5, horizontal: 5),
        child: InkWell(
          onTap: () => tapMenubar(page),
          child: Text("หน้า  $page"),
        ),
      ),
    );
  }
}
