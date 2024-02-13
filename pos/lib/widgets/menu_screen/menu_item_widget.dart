import 'package:flutter/material.dart';
import 'package:global_configuration/global_configuration.dart';

import '../../models/product_model.dart';

class MenuItemWidget extends StatelessWidget {
  final Product product;
  MenuItemWidget({required this.product, super.key});

  String _url = 'http://${GlobalConfiguration().get("server_endpoint")}/images/';

  @override
  Widget build(BuildContext context) {

    if (product.imagePath != 'NULL') {
      return InkWell(
        // onTap: () async {
        //   int popupDetailId = 4;
        //   if (widget.popupInfoId == 2) {
        //     await _displayTextInputDialog(context);
        //     popupDetailId = _getPopupDetailId();
        //   }
        //   cart.addItem(widget.id, popupDetailId, widget.price, widget.name, '', '');
        // },
        splashColor: Theme.of(context).primaryColor,
        borderRadius: BorderRadius.circular(15),
        child: GridTile(
          header: GridTileBar(
            backgroundColor: Colors.black45,
            title: Text(
              '${product.name} ${product.price.round()} บาท',
              textAlign: TextAlign.center,
            ),
          ),
          child: GestureDetector(
            child: Image.network(
              '${_url}${product.imagePath}',
              height: 100,
              width: 100,
              fit: BoxFit.cover,
            ),
          ),
        ),
      );

    } else {
      return InkWell(
        // onTap: () async {
        //   int popupDetailId = 4;
        //   if (widget.popupInfoId == 2) {
        //     await _displayTextInputDialog(context);
        //     popupDetailId = _getPopupDetailId();
        //   }
        //   cart.addItem(
        //       widget.id, popupDetailId, widget.price, widget.name, '', '');
        // },
        splashColor: Theme
            .of(context)
            .primaryColor,
        borderRadius: BorderRadius.circular(15),
        child: GridTile(
          header: GridTileBar(
            backgroundColor: Colors.black45,
            title: Text(
              '${product.price.round()} บาท',
              textAlign: TextAlign.center,
            ),
          ),
          child: Center(
              child: Text(
                product.name,
                textAlign: TextAlign.center,
              )),
        ),
      );
    }
  }
}
