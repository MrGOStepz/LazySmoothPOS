package com.lazysmooth.pos.controller;

import com.lazysmooth.pos.exception.LazySmoothException;
import com.lazysmooth.pos.exception.UtilsConverterException;
import com.lazysmooth.pos.model.db.CategoryInfo;
import com.lazysmooth.pos.service.CategoryInfoService;
import com.lazysmooth.pos.util.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/categoryInfo")
class CategoryInfoController extends AbstractController {
    private final CategoryInfoService categoryInfoService;

    @GetMapping(path = "/all")
    @ResponseBody
    public ResponseEntity<String> getAllCategoryInfo() {
        try {
            List<CategoryInfo> tableInfo = categoryInfoService.getAll();
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
    public ResponseEntity<String> getCategoryInfoById(@PathVariable Long id) {
        try {
            CategoryInfo categoryInfo = categoryInfoService.getById(id);
            String response = Utils.convertJsonObjecToString(categoryInfo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot Get TableInfo Id: %s.", id);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PostMapping(path = "/add")
    @ResponseBody
    public ResponseEntity<String> addNewCategoryInfo(@RequestBody String jsonReq) {
        try {
            CategoryInfo categoryInfo = (CategoryInfo) Utils.convertJsonStringToObject(jsonReq, CategoryInfo.class);
            categoryInfoService.add(categoryInfo);
            String response = String.format("Add new categoryInfo successfully: %s", categoryInfo);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (UtilsConverterException ex) {
            String errorMessage = String.format("Cannot convert Object from Request: %s.", jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot Add new CategoryInfo: %s.", jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping(path = "/update")
    public ResponseEntity<String> updateCategoryInfo(@RequestBody String jsonReq) {
        try {
            CategoryInfo categoryInfo = (CategoryInfo) Utils.convertJsonStringToObject(jsonReq, CategoryInfo.class);
            categoryInfoService.update(categoryInfo);
            String response = String.format("Update CategoryInfo: %s completed.", categoryInfo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (UtilsConverterException ex) {
            String errorMessage = String.format("Cannot convert Object from Request: %s.", jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot update CategoryInfo: %s.", jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoryInfo(@PathVariable Long id) {
        try {
            categoryInfoService.delete(id);
            String response = String.format("Delete CategoryInfo Id: %d completed.", id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot delete CategoryInfo Id: %d", id);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}