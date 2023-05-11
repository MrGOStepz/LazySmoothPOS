package com.lazysmooth.pos.model.response;

import lombok.Data;

@Data
public class OrderSummary {
    private Long productId;
    private Long popupDetailId;
    private Integer quantity;
    private Double amount;
}
