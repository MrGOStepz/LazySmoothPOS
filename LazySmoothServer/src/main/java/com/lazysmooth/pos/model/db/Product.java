package com.lazysmooth.pos.model.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "product")
public class Product {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native"
    )
    @GenericGenerator(
            name = "native"
    )
    @Column(
            name = "product_id",
            updatable = false
    )
    private Long id;
    private String name;
    private String description;
    private Double price;
    private String foodType;
    private Long categoryInfoId;
    private Long popupInfoId;
    private Integer locationPage;
    private Integer locationRow;
    private Integer locationColumn;
    private Integer stock;
    private String imagePath;
    private Boolean isAvailable;
}
