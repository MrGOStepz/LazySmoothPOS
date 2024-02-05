import 'dart:convert';

import 'package:flutter/material.dart';
import 'package:global_configuration/global_configuration.dart';
import 'package:http/http.dart' as http;

import '../models/table_info_model.dart';

class TableInfoProvider with ChangeNotifier {
  String serverEndpoint = GlobalConfiguration().get("server_endpoint");
  String tableUrl = '/api/v1/tableInfo/all';
  List<TableInfo> _items = [];

  List<TableInfo> get items {
    return _items;
  }

  void setItems(List<TableInfo> tableInfoList) {
    _items = tableInfoList;
    notifyListeners();
  }

  Future<void> fetchAndSetTableInfo() async {
    final url = Uri.http(serverEndpoint, tableUrl);
    final response = await http.get(url);
    final List<TableInfo> loadedTableInfo = [];
    final extractedData = jsonDecode(utf8.decode(response.bodyBytes));
    for (var value in extractedData) {
      loadedTableInfo.add(
        TableInfo(value["id"], value["name"], value["status"],
            value["orderInfoId"]),
      );
    }
    _items = loadedTableInfo.toList();
    notifyListeners();
  }

  TableInfo findByName(String name) {
    return _items.firstWhere((item) => item.name == name);
  }

  TableInfo findById(int id) {
    return _items.firstWhere((item) => item.tableInfoId == id);
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
