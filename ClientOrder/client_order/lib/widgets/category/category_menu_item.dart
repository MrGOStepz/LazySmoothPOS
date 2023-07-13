import 'package:flutter/material.dart';
import 'package:global_configuration/global_configuration.dart';

import '../../models/category_model.dart';

class CategoryMenuItem extends StatelessWidget {
  final Category category;
  final Function(int) selectCategory;

  const CategoryMenuItem(
      {required this.category, required this.selectCategory, Key? key})
      : super(key: key);

  @override
  Widget build(BuildContext context) {
    return SizedBox(
      height: 150,
      width:  150,
      child: GridTile(
        footer: GridTileBar(
          backgroundColor: Colors.black87,
          title: Text(
            category.name,
            textAlign: TextAlign.center,
          ),
        ),
        child: GestureDetector(
          onTap: () => selectCategory(category.id),
          child: Image.network(
            'http://${GlobalConfiguration().get("server_endpoint")}/images/${category.imagePath}',
            height: 100,
            width: 100,
            fit: BoxFit.cover,
          ),
        ),
      ),
    );
    // return Stack(
    //   children: [
    //     Container(
    //       height: 100,
    //       width: 100,
    //       child: Image.network('http://${GlobalConfiguration().get("server_endpoint")}/images/${category.imagePath}',
    //         height: 100,
    //         width: 100,
    //         fit: BoxFit.cover,),
    //     ),
    //     Container(
    //       elevation: 5,
    //       margin: const EdgeInsets.symmetric(vertical: 5, horizontal: 5),
    // alignment: Alignment.center,
    // child: InkWell(
    //   onTap: () => selectCategory(category.id),
    //   child: Text(category.name),
    // ),
    // ),
    // ],
    // );
  }
}
