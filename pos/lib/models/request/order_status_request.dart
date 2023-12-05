class OrderStatusRequest {
  int? orderInfoId;
  String? status;

  OrderStatusRequest(this.orderInfoId, this.status);

  OrderStatusRequest.fromJson(Map<String, dynamic> json) {
    orderInfoId = json['orderInfoId'];
    status = json['status'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    data['orderInfoId'] = orderInfoId;
    data['status'] = status;
    return data;
  }
}
