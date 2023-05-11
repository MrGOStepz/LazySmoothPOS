package com.lazysmooth.pos.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class TableStatusRequest {
    private String name;
    private String status;
}
