package com.lazysmooth.pos.model.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "table_info")
public class TableInfo {
//    @Id
//    @SequenceGenerator(
//            name = "table_info_sequence",
//            sequenceName = "table_current_state_sequence",
//            allocationSize = 1
//    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "table_current_state_sequence"
//    )
//    @Column(
//            name = "id",
//            updatable = false
//    )

    @Id
    @Column(name="table_info_id")
    private Long tableInfoId;

    private String name;

    private String status;

    @Column(name="order_info_id")
    private Integer orderInfoId;
}
