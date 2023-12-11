class Product {
  int productId = 0;
  String name = '';
  double price = 0.0;
  String foodType = "";
  int categoryInfoId = 0;
  int popupInfoId = 0;
  int locationPage = 0;
  int locationRow = 0;
  int locationColumn = 0;
  int stock = 0;
  String imagePath = "";
  bool isAvailable = false;

  Product(this.productId,
      this.name,
      this.price,
      this.foodType,
      this.categoryInfoId,
      this.popupInfoId,
      this.locationPage,
      this.locationRow,
      this.locationColumn,
      this.stock,
      this.imagePath,
      this.isAvailable);


  Product.fromJson(Map<String, dynamic> json) {
    productId = json['productId'];
    name = json['name'];
    price = json['price'];
    foodType = json['foodType'];
    categoryInfoId = json['categoryInfoId'];
    popupInfoId = json['popupInfoId'];
    locationPage = json['locationPage '];
    locationRow = json['locationRow'];
    locationColumn = json['locationColumn'];
    stock = json['stock'];
    imagePath = json['imagePath'];
    isAvailable = json['isAvailable'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    data['productId'] = productId;
    data['name'] = name;
    data['price'] = price;
    data['foodType'] = foodType;
    data['categoryInfoId'] = categoryInfoId;
    data['popupInfoId'] = popupInfoId;
    data['locationPage'] = locationPage;
    data['locationRow'] = locationRow;
    data['locationColumn'] = locationColumn;
    data['stock'] = stock;
    data['imagePath'] = imagePath;
    data['isAvailable'] = isAvailable;
    return data;
  }
}
