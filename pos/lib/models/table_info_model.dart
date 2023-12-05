class TableInfo {
  late final String name;
  late final String status;

  TableInfo({required this.name, required this.status});

  TableInfo.fromJson(
      Map<String, dynamic> json) {
    name = json['name'];
    status = json['status'];
  }

  Map<String, dynamic> toJson() {
    final Map<String, dynamic> data = <String, dynamic>{};
    data['name'] = name;
    data['status'] = status;
    return data;
  }
}
