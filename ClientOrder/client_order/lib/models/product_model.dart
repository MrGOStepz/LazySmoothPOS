class Product {
  final int id;
  final String name;
  final double price;
  final String foodType;
  final int categoryInfoId;
  final int popupInfoId;
  final int locationPage;
  final int locationRow;
  final int locationColumn;
  final int stock;
  final String imagePath;
  final bool isAvailable;

  Product(
      this.id,
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
}
