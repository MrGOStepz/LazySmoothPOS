import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:global_configuration/global_configuration.dart';
import 'package:http/http.dart' as http;

import '../models/table_info_model.dart';

class TableInfoProvider with ChangeNotifier {
  List<TableInfo> _items = [];

  List<TableInfo> get items {
    return [..._items];
  }

  void  setItems(List<TableInfo> tableInfoList){
    _items = tableInfoList;
    notifyListeners();
  }

  Future<void> fetchAndSetTableInfo() async {
    final url = Uri.http(GlobalConfiguration().get("server_endpoint"),
        '/api/v1/table/all');
    final response = await http.get(url);
    final List<TableInfo> loadedTableInfo = [];
    final extractedData = jsonDecode(utf8.decode(response.bodyBytes));
    for(var tableInfo in extractedData) {
      loadedTableInfo.add(
        TableInfo(name: tableInfo["name"], status: tableInfo["status"]),
      );
    }

    _items = loadedTableInfo.toList();
    notifyListeners();
  }



  TableInfo findByName(String name) {
    return _items.firstWhere((item) => item.name == name);
  }

  Future<void> addItem(TableInfo productItem) async {
    items.add(productItem);
    notifyListeners();
  }

  Future<int> deleteItem(int id) async {
    notifyListeners();
    return 1;
  }

  Future<int> updateItem(TableInfo productItem) async {
    notifyListeners();
    return 1;
  }
  
}