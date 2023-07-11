package com.lazysmooth.pos.model.response;

import com.lazysmooth.pos.model.CartItem;
import lombok.Data;

import java.util.List;

@Data
public class OrderResponse {
    private Long orderInfoId;
    private String tableName;
    private List<CartItem> items;
}
