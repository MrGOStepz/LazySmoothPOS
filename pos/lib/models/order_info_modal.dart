class OrderInfo {
  late final int id;
  late final String tableName;
  late final String receiptJson;
  late final String status;
  late final String orderType;
  late final double amount;
  late final String startedTime;
  late final String lastUpdatedTime;

  OrderInfo({
    required this.id,
    required this.tableName,
    required this.receiptJson,
    required this.status,
    required this.orderType,
    required this.amount,
    required this.startedTime,
    required this.lastUpdatedTime
  });

  OrderInfo.fromJson(Map<String, dynamic> json, this.id,
      this.tableName, this.receiptJson, this.status, this.orderType, this.amount,
     this.startedTime, this.lastUpdatedTime) {
    id = json['id'];
    tableName = json['tableName'];
    receiptJson = json['receiptJson'];
    status = json['status'];
    orderType = json['orderType'];
    amount = json['amount'];
    startedTime = json['startedTime'];
    lastUpdatedTime = json['lastUpdatedTime'];
  }
}