package com.lazysmooth.pos.controller;

import com.lazysmooth.pos.exception.LazySmoothException;
import com.lazysmooth.pos.exception.UtilsConverterException;
import com.lazysmooth.pos.model.db.TableInfo;
import com.lazysmooth.pos.model.request.TableStatusRequest;
import com.lazysmooth.pos.model.response.ErrorResponse;
import com.lazysmooth.pos.service.TableInfoService;
import com.lazysmooth.pos.util.Utils;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/tableinfo")
public class TableInfoController {
    private static final Logger logger = LogManager.getLogger(TableInfoController.class);

    private final TableInfoService tableInfoService;

    @GetMapping(path = "/all")
    @ResponseBody
    public ResponseEntity<List<TableInfo>> getAllTableInfo() {
        return new ResponseEntity<>(tableInfoService.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{name}")
    @ResponseBody
    public ResponseEntity<TableInfo> getTableInfoByName(@PathVariable String name) {
        TableInfo tableInfo = tableInfoService.getTableInfo(name);
        return new ResponseEntity<>(tableInfo, HttpStatus.OK);
    }

    @PostMapping(path = "/add")
    @ResponseBody
    public ResponseEntity<TableInfo> addTableInfo(@RequestBody String jsonReq) {
        TableInfo request = (TableInfo) Utils.convertJsonToObject(jsonReq, TableInfo.class);
        return new ResponseEntity<>(tableInfoService.add(request), HttpStatus.ACCEPTED);
    }

    @PostMapping(path = "/update")
    public ResponseEntity<String> updateTableInfo(@RequestBody String jsonReq) {
        TableInfo request = null;
        try {
            request = (TableInfo) Utils.convertJsonToObject(jsonReq, TableInfo.class);
            tableInfoService.update(request);
            String response = String.format("Updated TableInfo: %s Successfully.", request);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (UtilsConverterException ex) {
            logger.error(ex.getMessage());
            String errorMessage = String.format("Cannot Convert Object from Request: %s.", ex.getMessage());
            ErrorResponse errorResponse = new ErrorResponse(0, errorMessage, ex.getMessage());
            return new ResponseEntity<>(errorResponse.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot update TableInfo: %s.", request);
            ErrorResponse errorResponse = new ErrorResponse(0, errorMessage, ex.getMessage());
            return new ResponseEntity<>(errorResponse.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/update/status")
    public ResponseEntity<String> updateTableInfoStatus(@RequestBody String jsonReq) {
        TableStatusRequest request = null;
        try {
            request = (TableStatusRequest) Utils.convertJsonToObject(jsonReq, TableStatusRequest.class);
            tableInfoService.updateStatus(request.getStatus(), request.getName());
            String response = String.format("Updated TableInfo Status. Name: %s, Status: %s Successfully.", request.getName(), request.getStatus());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (UtilsConverterException ex) {
            String errorMessage = String.format("Cannot Convert Object from Request: %s.", ex.getMessage());
            ErrorResponse errorResponse = new ErrorResponse(0, errorMessage, ex.getMessage());
            return new ResponseEntity<>(errorResponse.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (LazySmoothException ex) {
            assert request != null;
            String errorMessage = String.format("Cannot update TableInfo Status. Name: %s, Status: %s.", request.getName(), request.getStatus());
            ErrorResponse errorResponse = new ErrorResponse(0, errorMessage, ex.getMessage());
            return new ResponseEntity<>(errorResponse.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
