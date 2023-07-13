import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:global_configuration/global_configuration.dart';
import 'package:http/http.dart' as http;

import '../models/product_model.dart';

class ProductProvider with ChangeNotifier {
  List<Product> _items = [];

  List<Product> get items {
    return [..._items];
  }

  Product findById(int id) {
    return _items.firstWhere((item) => item.id == id);
  }

  Future<void> fetchAndSetProducts() async {
    final url = Uri.http(
        GlobalConfiguration().get("server_endpoint"), '/api/v1/product/all');
    final response = await http.get(url);
    final List<Product> loadedProduct = [];
    final extractedData = jsonDecode(utf8.decode(response.bodyBytes));
    // final extractedData = json.decode(response.body) as List<dynamic>;

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
    debugPrint(_items.toString());
    notifyListeners();
  }

  Future<void> addItem(Product productItem) async {
    items.add(productItem);
    notifyListeners();
  }

  Future<int> deleteItem(int id) async {
    notifyListeners();
    return 1;
  }

  Future<int> updateItem(Product productItem) async {
    notifyListeners();
    return 1;
  }

  List<Product> getProductsByCategory(int categoryId) {
    return _items.where((item) => item.categoryInfoId == categoryId).toList();
  }

  Set<int> getNumberOfPageByCategory(int categoryId) {
    var pageNumber = <int>{};
    List<Product> tempProduct = getProductsByCategory(categoryId);
    tempProduct
        .where((pageProduct) => pageNumber.add(pageProduct.locationPage))
        .toList();
    return pageNumber;
  }

  List<Product> getProductsByCategoryAndPage(int categoryId, int page) {
    return _items
        .where((item) =>
            item.categoryInfoId == categoryId && item.locationPage == page)
        .toList();
  }
}
