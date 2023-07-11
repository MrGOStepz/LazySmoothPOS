package com.lazysmooth.pos.model.request;

import com.lazysmooth.pos.model.CartItem;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private String tableName;
    private List<CartItem> items;
}
