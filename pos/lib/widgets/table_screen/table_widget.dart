import 'package:flutter/material.dart';
import 'package:provider/provider.dart';

import '../../providers/tables_provider.dart';
import 'table_item_widget.dart';

class TableWidget extends StatelessWidget {
  const TableWidget({super.key});

  @override
  Widget build(BuildContext context) {
      SliverGridDelegate gridDelegate =
    const SliverGridDelegateWithMaxCrossAxisExtent(
      maxCrossAxisExtent: 200,
      childAspectRatio: 3 / 2,
      crossAxisSpacing: 20,
      mainAxisSpacing: 20,
    );
    return Consumer<TableInfoProvider>(
      builder: (ctx, table, _) => GridView.builder(
        gridDelegate: gridDelegate,
        itemCount: table.items.length,
        itemBuilder: (ctx, i) => TableItemWidget(
          tableName: table.items[i].name,
          status: table.items[i].status,
        ),
      ),
    );
  }
}
