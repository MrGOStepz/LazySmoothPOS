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
    @Column(
            name = "name"
    )
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Double price;
    @Column(name = "food_type")
    private String foodType;
    @Column(name = "category_info_id")
    private Long categoryInfoId;
    @Column(name = "popup_info_id")
    private Long popupInfoId;
    @Column(name = "location_page")
    private Integer locationPage;
    @Column(name = "location_row")
    private Integer locationRow;
    @Column(name = "location_column")
    private Integer locationColumn;
    @Column(name = "stock")
    private Integer stock;
    @Column(name = "image_path")
    private String imagePath;
    @Column(name = "is_available")
    private Boolean isAvailable;
}
