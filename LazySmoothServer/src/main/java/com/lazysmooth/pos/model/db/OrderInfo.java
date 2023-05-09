package com.lazysmooth.pos.model.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "order_info")
public class OrderInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String tableName;
    private String receiptJson;
    private String status;
    private String orderType;
    private Double amount;
    private Timestamp startedTime;
    private Timestamp lastUpdatedTime;
}
