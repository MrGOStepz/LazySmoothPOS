package com.lazysmooth.pos.db.repository;

import com.lazysmooth.pos.model.db.OrderDetail;
import com.lazysmooth.pos.model.db.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long> {

    List<OrderInfo> findByStatus(String status);
    List<OrderInfo> findByTableName(String tableName);
}
