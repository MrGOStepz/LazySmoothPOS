package com.lazysmooth.pos.model.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "order_item")
public class OrderDetail {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native"
    )
    @GenericGenerator(
            name = "native"
    )
    @Column(
            name = "order_detail_id",
            updatable = false
    )
    private Long id;
    private Long orderInfoId;
    private Long productId;
    private Long popupDetailId;
    private String productName;
    private Integer quantity;
    private Double price;
    private String comment;
    private String status;
    private Timestamp startedTime;
    private Timestamp lastUpdatedTime;
}
