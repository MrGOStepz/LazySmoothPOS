import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:global_configuration/global_configuration.dart';
import 'package:http/http.dart' as http;

import '../models/product_model.dart';

class ProductProvider with ChangeNotifier {
  String productUrl = '/api/v1/product/all';
  String serverEndpoint = GlobalConfiguration().get("server_endpoint");
  List<Product> _items = [];

  List<Product> get items {
    return _items;
  }

  Product findById(int id) {
    return _items.firstWhere((item) => item.productId == id);
  }

  void fetchAndSetProducts() async {
    final url = Uri.http(serverEndpoint, productUrl);
    final response = await http.get(url);
    final List<Product> loadedProduct = [];
    final extractedData = jsonDecode(utf8.decode(response.bodyBytes));

    for (var value in extractedData) {
      loadedProduct.add(
        Product(
            value["id"],
            value["name"],
            value["price"],
            value["foodType"],
            value["categoryInfoId"],
            value["popupInfoId"],
            value["locationPage"],
            value["locationRow"],
            value["locationColumn"],
            value["stock"],
            value["imagePath"],
            value["isAvailable"]),
      );
    }

    _items = loadedProduct.toList();
    notifyListeners();
  }
}