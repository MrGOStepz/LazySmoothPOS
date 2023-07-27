package com.lazysmooth.pos.service;


import com.lazysmooth.pos.db.repository.ProductRepository;
import com.lazysmooth.pos.exception.LazySmoothException;
import com.lazysmooth.pos.model.db.Product;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class ProductService {
    private static final Logger logger = LogManager.getLogger(ProductService.class);

    private final Map<Long, Product> products = new HashMap<>();
    private final ProductRepository repository;

//    @Autowired
//    public void init() {
//        List<Product> productList = repository.findAll();
//        updateProductCache(productList);
//    }
    
//    ProductService() {
//        List<Product> productList = repository.findAll();
//        updateProductCache(productList);
//    }

    private void updateProductCache(List<Product> productList) {
        for (Product product : productList) {
            products.put(product.getId(), product);
        }
    }

    public Product getProductByCache(Long id) {
        return products.get(id);
    }
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

