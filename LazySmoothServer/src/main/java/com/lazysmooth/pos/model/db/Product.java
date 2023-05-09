package com.lazysmooth.pos.model.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(
            name = "product_id",
            updatable = false
    )
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String foodType;
    private Integer categoryInfoId;
    private Integer popupInfoId;
    private Integer locationPage;
    private Integer locationRow;
    private Integer locationColumn;
    private Integer stock;
    private String imagePath;
    private Boolean isAvailable;
}
