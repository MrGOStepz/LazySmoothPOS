class TableInfo {
  int tableInfoId = 0;
  String name = "";
  String status = "";
  int orderId = 0;

  TableInfo(
      this.tableInfoId,
      this.name,
      this.status,
      this.orderId,
      );

  TableInfo.fromJson(
      Map<String, dynamic> json) {
    tableInfoId = json['tableInfoId'];
    name = json['name'];
    status = json['status'];
    orderId = json['orderId'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    data['tableInfoId'] = tableInfoId;
    data['name'] = name;
    data['status'] = status;
    data['orderId'] = orderId;
    return data;
  }
}
