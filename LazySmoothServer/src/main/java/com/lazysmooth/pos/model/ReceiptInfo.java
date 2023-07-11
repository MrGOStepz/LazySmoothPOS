package com.lazysmooth.pos.model;

import com.lazysmooth.pos.model.db.OrderDetail;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ReceiptInfo {
    List<OrderDetail> orderDetails = new ArrayList<>();
}
