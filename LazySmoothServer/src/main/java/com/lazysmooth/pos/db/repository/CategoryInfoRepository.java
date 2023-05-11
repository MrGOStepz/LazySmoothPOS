package com.lazysmooth.pos.db.repository;

import com.lazysmooth.pos.model.db.CategoryInfo;
import com.lazysmooth.pos.model.db.TableInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface CategoryInfoRepository extends JpaRepository<CategoryInfo, Long> {

}
