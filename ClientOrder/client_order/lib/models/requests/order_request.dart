import '../cart_item_model.dart';

class CartRequest {
  String? tableName;
  List<CartItem>? cartItems;

  CartRequest(this.tableName, this.cartItems);

  CartRequest.fromJson(Map<String, dynamic> json) {
    tableName = json['tableName'];
    cartItems = json['cartItems'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    data['tableName'] = tableName;
    data['cartItems'] = cartItems;
    return data;
  }
}