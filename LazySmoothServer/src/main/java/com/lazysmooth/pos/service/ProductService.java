package com.lazysmooth.pos.service;


import com.lazysmooth.pos.db.repository.ProductRepository;
import com.lazysmooth.pos.exception.LazySmoothException;
import com.lazysmooth.pos.model.db.Product;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private static final Logger logger = LogManager.getLogger(ProductService.class);

    private final ProductRepository repository;

    public List<Product> getAll() {
        try {
            List<Product> productList = repository.findAll();
            logger.debug("Get All Product: {}", productList);
            return productList;
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }

    public Product getById(Long id) {
        try {
            Optional<Product> opt = repository.findById(id);
            Product product = opt.orElseGet(Product::new);
            logger.debug("Get Product: {}", product);
            return product;
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }

    public Product add(Product product) {
        try {
            var retObject = repository.save(product);
            repository.flush();
            product.setId(retObject.getId());
            logger.info("Add new Product: {} \nSuccessfully.", product);
            return product;
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }

    }

    public void update(Product product) {
        try {
            repository.save(product);
            logger.info("Updated Product: {}. Successfully", product);
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
            logger.info("Deleted Product: {} Successfully.", id);
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }
}

