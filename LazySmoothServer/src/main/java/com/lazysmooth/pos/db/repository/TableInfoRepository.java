package com.lazysmooth.pos.db.repository;

import com.lazysmooth.pos.model.db.TableInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TableInfoRepository extends JpaRepository<TableInfo, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE table_info ti SET ti.status = :status WHERE ti.name = :name")
    void updateTableInfoStatusByName(@Param("status")String status, @Param("name")String name);

    @Transactional
    @Modifying
    @Query("UPDATE table_info ti SET ti.name = :name, ti.status = :status, ti.orderInfoId = :orderInfoId WHERE ti.tableInfoId = :tableInfoId")
    void updateTableInfo(@Param("tableInfoId")Long tableInfoId, @Param("name")String name, @Param("status")String status, @Param("orderInfoId")Integer order);

    List<TableInfo> findByName(String name);

}
