import 'package:client_order/providers/carts_provider.dart';
import 'package:flutter/material.dart';
import 'package:global_configuration/global_configuration.dart';
import 'package:provider/provider.dart';

import 'config/app_settings.dart';
import 'providers/categories_provider.dart';
import 'providers/products_provider.dart';
import 'screens/overview_screen.dart';
import 'services/web_socket.dart';

void main() {
  GlobalConfiguration().loadFromMap(appSettings);
  runApp(const ClientOrderApp());
}

class ClientOrderApp extends StatelessWidget {
  const ClientOrderApp({super.key});

  @override
  Widget build(BuildContext context) {
    stompClient.activate();
    return MultiProvider(
      providers: [
        ChangeNotifierProvider.value(
          value: ProductProvider(),
        ),
        ChangeNotifierProvider.value(
          value: CategoryProvider(),
        ),
        ChangeNotifierProvider.value(
          value: CartProvider(),
        )
      ],
      child: MaterialApp(
        title: 'MyShop',
        theme: ThemeData(
          fontFamily: 'Lato',
          colorScheme: ColorScheme.fromSwatch(primarySwatch: Colors.purple)
              .copyWith(secondary: Colors.deepOrange),
        ),
        home: const OrderOverViewScreen(),
      ),
    );
  }
}
