import 'package:flutter/material.dart';
import 'package:pos/widgets/menu_screen/menu_widget.dart';

class MenuScreen extends StatelessWidget {
  const MenuScreen({super.key});

  @override
  Widget build(BuildContext context) {
    return Row(
      children: [
        Expanded(
          flex: 8,
          child: MenuWidget(),
        ),
        Expanded(
          flex: 2,
          child: Text("Order"),
        ),
      ],
    );
  }
}

