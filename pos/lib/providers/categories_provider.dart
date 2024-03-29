import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:global_configuration/global_configuration.dart';
import 'package:http/http.dart' as http;

import '../models/category_model.dart';

class CategoryProvider with ChangeNotifier {
  final String _serverEndpoint = GlobalConfiguration().get("server_endpoint");
  final String _categoryUrl = '/api/v1/categoryInfo/all';

  List<Category> _items = [];

  List<Category> get items {
    return _items;
  }

  Future<void> fetchAndSetCategory() async {
    final url = Uri.http(_serverEndpoint, _categoryUrl);
    final response = await http.get(url);
    final List<Category> loadedCategory = [];
    final extractedData = jsonDecode(utf8.decode(response.bodyBytes));
    for (var category in extractedData) {
      loadedCategory.add(
        Category(category["categoryInfoId"], category["name"],
            category["imagePath"]),
      );
    }

    _items = loadedCategory.toList();
    notifyListeners();
  }

  Category findById(int id) {
    return _items.firstWhere((item) => item.id == id);
  }

  Future<void> addItem(Category productItem) async {
    items.add(productItem);
    notifyListeners();
  }

  Future<int> deleteItem(int id) async {
    notifyListeners();
    return 1;
  }

  Future<int> updateItem(Category productItem) async {
    notifyListeners();
    return 1;
  }
}
