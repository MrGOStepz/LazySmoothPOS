package com.lazysmooth.pos.db.repository;

import com.lazysmooth.pos.model.db.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
    List<OrderDetail> findByOrderInfoId(Long orderInfoId);
    List<OrderDetail> findByOrderInfoIdIn(List<Long> orderInfoId);
}
