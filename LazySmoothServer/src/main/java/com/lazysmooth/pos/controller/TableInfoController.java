package com.lazysmooth.pos.controller;

import com.lazysmooth.pos.exception.LazySmoothException;
import com.lazysmooth.pos.exception.UtilsConverterException;
import com.lazysmooth.pos.model.db.TableInfo;
import com.lazysmooth.pos.model.request.TableStatusRequest;
import com.lazysmooth.pos.service.TableInfoService;
import com.lazysmooth.pos.util.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/tableInfo")
public class TableInfoController extends AbstractController {
    private final TableInfoService tableInfoService;

    @GetMapping(path = "/all")
    @ResponseBody
    public ResponseEntity<String> getAllTableInfo() {
        try {
            List<TableInfo> tableInfo = tableInfoService.getAll();
            String response = Utils.convertJsonObjecToString(tableInfo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (LazySmoothException ex) {
            String errorMessage = "Cannot Get All TableInfo";
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{name}")
    @ResponseBody
    public ResponseEntity<String> getTableInfoByName(@PathVariable String name) {
        try {
            TableInfo tableInfo = tableInfoService.getTableInfo(name);
            String response = Utils.convertJsonObjecToString(tableInfo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot Get TableInfo Id: %s.", name);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/add")
    @ResponseBody
    public ResponseEntity<String> addTableInfo(@RequestBody String jsonReq) {
        try {
            TableInfo request = (TableInfo) Utils.convertJsonStringToObject(jsonReq, TableInfo.class);
            TableInfo result = tableInfoService.add(request);
            String response = Utils.convertJsonObjecToString(result);
            return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
        } catch (UtilsConverterException ex) {
            String errorMessage = String.format("Cannot Convert Object from Request: %s.", jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot Add new TableInfo: %s.", jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/update")
    public ResponseEntity<String> updateTableInfo(@RequestBody String jsonReq) {
        TableInfo request = null;
        try {
            request = (TableInfo) Utils.convertJsonStringToObject(jsonReq, TableInfo.class);
            tableInfoService.update(request);
            String response = String.format("Updated TableInfo: %s Successfully.", request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (UtilsConverterException ex) {
            String errorMessage = String.format("Cannot Convert Object from Request: %s.", jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot update TableInfo: %s.", request);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/update/status")
    public ResponseEntity<String> updateTableInfoStatus(@RequestBody String jsonReq) {
        TableStatusRequest request = null;
        try {
            request = (TableStatusRequest) Utils.convertJsonStringToObject(jsonReq, TableStatusRequest.class);
            tableInfoService.updateStatus(request.getStatus(), request.getName());
            String response = String.format("Updated TableInfo Status. Name: %s, Status: %s Successfully.", request.getName(), request.getStatus());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (UtilsConverterException ex) {
            String errorMessage = String.format("Cannot convert Object from Request: %s.", jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (LazySmoothException ex) {
            assert request != null;
            String errorMessage = String.format("Cannot update TableInfo Status. Name: %s, Status: %s.", request.getName(), request.getStatus());
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategoryInfo(@PathVariable Long id) {
        try {
            tableInfoService.delete(id);
            String response = String.format("Delete CategoryInfo Id: %d completed.", id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot delete TableInfo Id: %d", id);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}