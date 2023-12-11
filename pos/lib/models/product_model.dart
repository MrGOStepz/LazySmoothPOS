class Product {
  int id = 0;
  String name = '';
  double price = 0.0;
  String foodType = "";
  int categoryInfoId = 0;
  int locationPage = 0;
  int locationRow = 0;
  int locationColumn = 0;
  int stock = 0;
  String imagePath = "";
  bool isAvailable = false;

  Product(this.id,
      this.name,
      this.price,
      this.foodType,
      this.categoryInfoId,
      this.locationPage,
      this.locationRow,
      this.locationColumn,
      this.stock,
      this.imagePath,
      this.isAvailable);


  Product.fromJson(Map<String, dynamic> json) {
    id = json['productId'];
    name = json['name'];
    price = json['status'];
    foodType = json['foodType'];
    categoryInfoId = json['categoryInfoId'];
    locationPage = json['locationPage '];
    locationRow = json['locationRow'];
    categoryInfoId = json['categoryInfoId'];
    categoryInfoId = json['categoryInfoId'];
    categoryInfoId = json['categoryInfoId'];
    categoryInfoId = json['categoryInfoId'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    data['name'] = name;
    data['status'] = status;
    return data;
  }
}
