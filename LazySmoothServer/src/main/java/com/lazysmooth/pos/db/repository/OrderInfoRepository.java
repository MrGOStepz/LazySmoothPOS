package com.lazysmooth.pos.db.repository;

import com.lazysmooth.pos.model.db.OrderInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderInfoRepository extends JpaRepository<OrderInfo, Long> {
}
