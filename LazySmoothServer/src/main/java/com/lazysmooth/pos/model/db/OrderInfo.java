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
@Entity(name = "order_info")
public class OrderInfo {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native"
    )
    @GenericGenerator(
            name = "native"
    )
    @Column(
            name = "order_info_id",
            updatable = false
    )
    private Long id;
    private String tableName;
    private String receiptJson;
    private String status;
    private String orderType;
    private Double amount;
    private Timestamp startedTime;
    private Timestamp lastUpdatedTime;
}
