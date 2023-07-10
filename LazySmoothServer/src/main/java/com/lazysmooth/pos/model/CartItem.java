package com.lazysmooth.pos.model;

import lombok.Data;

@Data
public class CartItem {
    private Long productId;
    private Long popupDetailId;
    private String name;
    private String description;
    private Integer quantity;
    private Double price;
    private String comment;
}

