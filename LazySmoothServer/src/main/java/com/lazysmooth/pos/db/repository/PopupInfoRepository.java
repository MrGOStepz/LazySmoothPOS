package com.lazysmooth.pos.db.repository;

import com.lazysmooth.pos.model.db.OrderDetail;
import com.lazysmooth.pos.model.db.PopupInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PopupInfoRepository extends JpaRepository<PopupInfo, Long> {
}
