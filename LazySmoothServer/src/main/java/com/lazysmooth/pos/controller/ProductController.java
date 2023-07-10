package com.lazysmooth.pos.controller;

import com.lazysmooth.pos.exception.LazySmoothException;
import com.lazysmooth.pos.exception.UtilsConverterException;
import com.lazysmooth.pos.model.db.Product;
import com.lazysmooth.pos.service.ProductService;
import com.lazysmooth.pos.util.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/product")
public class ProductController extends AbstractController {
    private final ProductService productService;

    @GetMapping(path = "/all")
    @ResponseBody
    public ResponseEntity<String> getAllProduct() {
        try {
            List<Product> tableInfo = productService.getAll();
            String response = Utils.convertJsonObjecToString(tableInfo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (LazySmoothException ex) {
            String errorMessage = "Cannot Get All TableInfo";
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity<String> getProductById(@PathVariable Long id) {
        try {
            Product product = productService.getById(id);
            String response = Utils.convertJsonObjecToString(product);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot Get TableInfo Id: %s.", id);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/add")
    @ResponseBody
    public ResponseEntity<String> addNewProduct(@RequestBody String jsonReq) {
        try {
            Product product = (Product) Utils.convertJsonStringToObject(jsonReq, Product.class);
            productService.add(product);
            String response = String.format("Add new product successfully: %s", product);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (UtilsConverterException ex) {
            String errorMessage = String.format("Cannot convert Object from Request: %s.", jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot Add new Product: %s.", jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/update")
    public ResponseEntity<String> updateProduct(@RequestBody String jsonReq) {
        try {
            Product product = (Product) Utils.convertJsonStringToObject(jsonReq, Product.class);
            productService.update(product);
            String response = String.format("Update Product: %s completed.", product);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (UtilsConverterException ex) {
            String errorMessage = String.format("Cannot convert Object from Request: %s.", jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot update Product: %s.", jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        try {
            productService.delete(id);
            String response = String.format("Delete Product Id: %d completed.", id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot delete Product Id: %d", id);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}