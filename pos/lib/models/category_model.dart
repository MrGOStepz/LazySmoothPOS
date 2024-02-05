class Category {
  late final int id;
  late final String name;
  late final String imagePath;

  Category(this.id, this.name, this.imagePath);

  Category.fromJson(Map<String, dynamic> json) {
    id = json['categoryInfoId'];
    name = json['name'];
    imagePath = json['imagePath'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    data['categoryId'] = id;
    data['name'] = name;
    data['imagePath'] = imagePath;
    return data;
  }
}
