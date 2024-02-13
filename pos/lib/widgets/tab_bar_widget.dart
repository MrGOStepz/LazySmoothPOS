import 'package:flutter/material.dart';
import 'package:pos/models/enum/screen_state.dart';

class TabBarWidget extends StatelessWidget {
  final Function screenState;

  const TabBarWidget({super.key, required this.screenState});

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        Expanded(
          flex: 1,
          child: TextButton(
            onPressed: () => screenState(ScreenState.tableScreen),
            child: const Text('Logo'),
          ),
        ),
        Expanded(
          flex: 1,
          child: TextButton(
            onPressed: () => screenState(ScreenState.tableScreen),
            child: const Text('Table'),
          ),
        ),
        Expanded(
         flex: 1,
          child: TextButton(
            onPressed: () => screenState(ScreenState.menuScreen),
            child: const Text('Menu'),
          ),
        ),
        Expanded(
          flex: 1,
          child: TextButton(
            onPressed: () => screenState(ScreenState.dashboardScreen),
            child: const Text('Kitchen'),
          ),
        ),
        Expanded(
          flex: 1,
          child: TextButton(
            onPressed: () => screenState(ScreenState.dashboardScreen),
            child: const Text('Dashboard'),
          ),
        ),
        Expanded(
          flex: 1,
          child: TextButton(
            onPressed:() => screenState(ScreenState.loginScreen),
            child: const Text('Logout'),
          ),
        ),
      ],
    );
  }
}
