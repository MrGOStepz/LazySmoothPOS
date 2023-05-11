package com.lazysmooth.pos.controller;

import com.lazysmooth.pos.model.db.CategoryInfo;
import com.lazysmooth.pos.service.CategoryInfoService;
import com.lazysmooth.pos.util.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/categoryInfo")
class CategoryInfoController {

    private static final Logger logger = LogManager.getLogger(CategoryInfoController.class);

    private final CategoryInfoService categoryInfoService;

    @GetMapping(path = "/all")
    @ResponseBody
    public ResponseEntity<List<CategoryInfo>> getAllCategoryInfo() {
        return new ResponseEntity<>(categoryInfoService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity<CategoryInfo> getCategoryInfoById(@PathVariable Long id) {
        CategoryInfo categoryInfo = categoryInfoService.getById(id);
        return new ResponseEntity<>(categoryInfo, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    @ResponseBody
    public ResponseEntity<String> addNewCategoryInfo(@RequestBody String jsonReq) {
        CategoryInfo categoryInfo = (CategoryInfo) Utils.convertJsonToObject(jsonReq, CategoryInfo.class);
        categoryInfoService.add(categoryInfo);
        return new ResponseEntity<>(String.format("Add new categoryInfo successfully: %s", categoryInfo), HttpStatus.CREATED);
    }

    @PutMapping(path = "/update")
    public String updateCategoryInfo(@RequestBody String jsonReq) {
        CategoryInfo categoryInfo = (CategoryInfo) Utils.convertJsonToObject(jsonReq, CategoryInfo.class);
        categoryInfoService.update(categoryInfo);
        return String.format("Update CategoryInfo: %s completed.", categoryInfo);
    }

    @DeleteMapping("/{id}")
    public String deleteCategoryInfo(@PathVariable Long id) {
        categoryInfoService.delete(id);
        return String.format("Delete CategoryInfo Id: %d completed.", id);
    }

}

