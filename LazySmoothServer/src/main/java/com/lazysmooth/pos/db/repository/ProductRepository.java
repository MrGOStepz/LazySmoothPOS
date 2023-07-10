package com.lazysmooth.pos.db.repository;

import com.lazysmooth.pos.model.db.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
