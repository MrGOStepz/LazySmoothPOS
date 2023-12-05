package com.lazysmooth.pos.model.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "category_info")
public class CategoryInfo {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native"
    )
    @GenericGenerator(
            name = "native"
    )
    @Column(
            name = "category_info_id"
    )
    private Long categoryInfoId;
    private String name;
    private String imagePath;
}
