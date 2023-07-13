import 'package:client_order/widgets/noodle_type/noodle_type_item.dart';
import 'package:flutter/material.dart';
import 'package:global_configuration/global_configuration.dart';
import 'package:provider/provider.dart';

import '../../providers/carts_provider.dart';

class ProductMenuItem extends StatefulWidget {
  final int id;
  final int popupInfoId;
  final String name;
  final double price;
  final String imagePath;

  const ProductMenuItem(
      {Key? key,
      required this.id,
      required this.popupInfoId,
      required this.name,
      required this.price,
      required this.imagePath})
      : super(key: key);

  @override
  State<ProductMenuItem> createState() => _ProductMenuItemState();
}

enum NoodleType { udon, udonFlat, ramen }
class _ProductMenuItemState extends State<ProductMenuItem> {
  late String valueText;
  late String codeDialog;
  late int price;
  TextEditingController _textFieldController = TextEditingController();

  NoodleType? _noodleType = NoodleType.udon;

  // Future<void> _displayTextInputDialog(BuildContext context) async {
  //   return showDialog(
  //     context: context,
  //     builder: (context) {
  //       return AlertDialog(
  //         title: Text('TextField in Dialog'),
  //         content: TextField(
  //           onChanged: (value) {
  //             setState(() {
  //               valueText = value;
  //             });
  //           },
  //           controller: _textFieldController,
  //           decoration: InputDecoration(hintText: "Text Field in Dialog"),
  //         ),
  //         actions: [
  //           TextButton(
  //             onPressed: () {
  //               setState(() {
  //                 Navigator.pop(context);
  //               });
  //             },
  //             child: Text("Cancel"),
  //           ),
  //           TextButton(
  //             onPressed: () {
  //               setState(() {
  //                 codeDialog = valueText;
  //                 Navigator.pop(context);
  //               });
  //             },
  //             child: Text("Ok"),
  //           ),
  //         ],
  //       );
  //     },
  //   );
  // }

  Future<void> _displayTextInputDialog(BuildContext context) async {
    return showDialog(
      context: context,
      builder: (context) {
        return AlertDialog(
          title: Text('เลือกชนิดเส้น'),
          content: StatefulBuilder(
              builder: (BuildContext context, StateSetter setState) {
                return Column(
                  children: [
                    ListTile(
                      title: const Text('อุด้ง'),
                      leading: Radio<NoodleType>(
                        value: NoodleType.udon,
                        groupValue: _noodleType,
                        onChanged: (NoodleType? value) {
                          setState(() {
                            _noodleType = value;
                          });
                        },
                      ),
                    ),
                    ListTile(
                      title: const Text('อุด้งแบน'),
                      leading: Radio<NoodleType>(
                        value: NoodleType.udonFlat,
                        groupValue: _noodleType,
                        onChanged: (NoodleType? value) {
                          setState(() {
                            _noodleType = value;
                          });
                        },
                      ),
                    ),
                    ListTile(
                      title: const Text('ราเมน'),
                      leading: Radio<NoodleType>(
                        value: NoodleType.ramen,
                        groupValue: _noodleType,
                        onChanged: (NoodleType? value) {
                          setState(() {
                            _noodleType = value;
                          });
                        },
                      ),
                    ),
                  ],
                );
              }
          ),
          actions: [
            TextButton(
              onPressed: () {
                setState(() {
                  Navigator.pop(context);
                });
              },
              child: Text("Cancel"),
            ),
            TextButton(
              onPressed: () {
                setState(() {
                  // codeDialog = valueText;
                  Navigator.pop(context);
                });
              },
              child: Text("Ok"),
            ),
          ],
        );
      },
    );
  }

  int _getPopupDetailId() {
      if(_noodleType == NoodleType.udon) {
        return 1;
      } else if (_noodleType == NoodleType.udonFlat) {
        return 2;
      } else {
        return 3;
      }
  }

  @override
  Widget build(BuildContext context) {
    final cart = Provider.of<CartProvider>(context, listen: true);
    if (widget.imagePath != 'NULL') {
      return InkWell(
        onTap: () async {
          int popupDetailId = 4;
          if (widget.popupInfoId == 2) {
            await _displayTextInputDialog(context);
            popupDetailId = _getPopupDetailId();
          }
          cart.addItem(widget.id, popupDetailId, widget.price, widget.name, '', '');
        },
        splashColor: Theme.of(context).primaryColor,
        borderRadius: BorderRadius.circular(15),
        child: GridTile(
          header: GridTileBar(
            backgroundColor: Colors.black45,
            title: Text(
              '${widget.name} ${widget.price.round()} บาท',
              textAlign: TextAlign.center,
            ),
          ),
          child: GestureDetector(
            child: Image.network(
              'http://${GlobalConfiguration().get("server_endpoint")}/images/${widget.imagePath}',
              height: 100,
              width: 100,
              fit: BoxFit.cover,
            ),
          ),
        ),
      );
    } else {
      return InkWell(
        onTap: () async {
            int popupDetailId = 4;
           if(widget.popupInfoId == 2) {
             await _displayTextInputDialog(context);
             popupDetailId = _getPopupDetailId();
           }
          cart.addItem(widget.id, popupDetailId, widget.price, widget.name, '', '');
        },
        splashColor: Theme.of(context).primaryColor,
        borderRadius: BorderRadius.circular(15),
        child: GridTile(
          header: GridTileBar(
            backgroundColor: Colors.black45,
            title: Text(
              '${widget.price.round()} บาท',
              textAlign: TextAlign.center,
            ),
          ),
          child: Center(
              child: Text(
            widget.name,
            textAlign: TextAlign.center,
          )),
        ),
      );
    }
  }
}
