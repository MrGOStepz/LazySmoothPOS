class CartItem {
  late final int productId;
  late final int popupDetailId;
  late final String name;
  late final String description;
  late final int quantity;
  late final double price;
  late final String comment;

  CartItem({
    required this.productId,
    required this.popupDetailId,
    required this.name,
    required this.description,
    required this.price,
    required this.quantity,
    required this.comment,
  });

  CartItem.fromJson(Map<String, dynamic> json, this.productId, this.name,
      this.description, this.quantity, this.price, this.comment) {
    productId = json['productId'];
    popupDetailId = json['popupDetailId'];
    name = json['name'];
    description = json['description'];
    quantity = json['quantity'];
    price = json['price'];
    comment = json['comment'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = new Map<String, dynamic>();
    data['productId'] = productId;
    data['popupDetailId'] = popupDetailId;
    data['name'] = name;
    data['description'] = description;
    data['quantity'] = quantity;
    data['price'] = price;
    data['comment'] = comment;
    return data;
  }
}
