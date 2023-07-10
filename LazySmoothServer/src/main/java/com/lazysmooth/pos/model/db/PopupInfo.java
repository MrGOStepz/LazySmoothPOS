package com.lazysmooth.pos.model.db;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "popup_info")
public class PopupInfo {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native"
    )
    @GenericGenerator(
            name = "native"
    )
    @Column(
            name = "popup_info_id",
            updatable = false
    )
    private Long id;
    private String name;
}
