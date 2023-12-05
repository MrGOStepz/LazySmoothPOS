class OrderDetail {
  late int orderDetailId;
  late int productId;
  late int orderInfoId;
  late int popupDetailId;
  late String status;
  late int quantity;
  late double price;
  late String comment;
  late String startedTime;
  late String lastUpdatedTime;
  late String productName;

  OrderDetail({
    required this.orderDetailId,
    required this.productId,
    required this.orderInfoId,
    required this.popupDetailId,
    required this.status,
    required this.quantity,
    required this.price,
    required this.comment,
    required this.startedTime,
    required this.lastUpdatedTime
  });

  OrderDetail.fromJson(Map<String, dynamic> json, this.orderDetailId,
      this.productId, this.orderInfoId, this.status, this.quantity, this.price,
      this.comment, this.startedTime, this.lastUpdatedTime) {
    orderDetailId = json['orderDetailId'];
    productId = json['productId'];
    orderInfoId = json['orderInfoId'];
    popupDetailId = json['popupDetailId'];
    status = json['status'];
    quantity = json['quantity'];
    price = json['price'];
    comment = json['comment'];
    startedTime = json['startedTime'];
    lastUpdatedTime = json['lastUpdatedTime'];
  }


  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    data['orderDetailId'] = orderDetailId;
    data['productId'] = productId;
    data['orderInfoId'] = orderInfoId;
    data['popupDetailId'] = popupDetailId;
    data['status'] = status;
    data['quantity'] = quantity;
    data['price'] = price;
    data['comment'] = comment;
    data['startedTime'] = startedTime;
    data['lastUpdatedTime'] = lastUpdatedTime;
    return data;
  }

}