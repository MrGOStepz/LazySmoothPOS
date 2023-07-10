package com.lazysmooth.pos.model.db;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "popup_detail")
public class PopupDetail {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native"
    )
    @GenericGenerator(
            name = "native"
    )
    @Column(
            name = "popup_detail_id",
            updatable = false
    )
    private Long id;
    private Long popupInfoId;
    private String name;
    private Double price;
}
