package com.lazysmooth.pos.db.repository;

import com.lazysmooth.pos.model.db.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
