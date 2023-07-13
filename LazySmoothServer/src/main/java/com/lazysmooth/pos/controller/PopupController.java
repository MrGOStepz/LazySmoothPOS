package com.lazysmooth.pos.controller;

import com.lazysmooth.pos.exception.LazySmoothException;
import com.lazysmooth.pos.exception.UtilsConverterException;
import com.lazysmooth.pos.model.db.PopupDetail;
import com.lazysmooth.pos.model.db.PopupInfo;
import com.lazysmooth.pos.service.PopupService;
import com.lazysmooth.pos.util.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/popup")
public class PopupController extends AbstractController {
    private final PopupService popupService;


    @GetMapping(path = "/all")
    @ResponseBody
    public ResponseEntity<String> getAllPopupInfo() {
        try {
            List<PopupInfo> popupInfo = popupService.getPopupInfoAll();
            String response = Utils.convertJsonObjecToString(popupInfo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (LazySmoothException ex) {
            String errorMessage = "Cannot Get All PopupInfo";
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    @ResponseBody
    public ResponseEntity<String> getPopupInfoById(@PathVariable Long id) {
        try {
            PopupInfo popupInfo = popupService.getPopupInfoById(id);
            String response = Utils.convertJsonObjecToString(popupInfo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot Get PopupInfo Id: %s.", id);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/add")
    @ResponseBody
    public ResponseEntity<String> addNewPopupInfo(@RequestBody String jsonReq) {
        try {
            PopupInfo popupInfo = (PopupInfo) Utils.convertJsonStringToObject(jsonReq, PopupInfo.class);
            popupInfo = popupService.addPopupInfo(popupInfo);
            String response = String.format("Add new popupInfo successfully: %s", popupInfo);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (UtilsConverterException ex) {
            String errorMessage = String.format(CAN_NOT_CONVERT_OBJECT, jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot Add new PopupInfo: %s.", jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/update")
    public ResponseEntity<String> updatePopupInfo(@RequestBody String jsonReq) {
        try {
            PopupInfo popupInfo = (PopupInfo) Utils.convertJsonStringToObject(jsonReq, PopupInfo.class);
            popupService.updatePopupInfo(popupInfo);
            String response = String.format("Update PopupInfo: %s completed.", popupInfo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (UtilsConverterException ex) {
            String errorMessage = String.format(CAN_NOT_CONVERT_OBJECT, jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot update PopupInfo: %s.", jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePopupInfo(@PathVariable Long id) {
        try {
            popupService.deletePopupInfo(id);
            String response = String.format("Delete PopupInfo Id: %d completed.", id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot delete PopupInfo Id: %d", id);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "detail/all")
    @ResponseBody
    public ResponseEntity<String> getAllPopupDetail() {
        try {
            List<PopupDetail> popupDetail = popupService.getPopupDetailAll();
            String response = Utils.convertJsonObjecToString(popupDetail);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (LazySmoothException ex) {
            String errorMessage = "Cannot Get All PopupDetail";
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "detail/{id}")
    @ResponseBody
    public ResponseEntity<String> getPopupDetailById(@PathVariable Long id) {
        try {
            PopupDetail popupDetail = popupService.getPopupDetailById(id);
            String response = Utils.convertJsonObjecToString(popupDetail);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot Get PopupDetail Id: %s.", id);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "detail/add")
    @ResponseBody
    public ResponseEntity<String> addNewPopupDetail(@RequestBody String jsonReq) {
        try {
            PopupDetail popupDetail = (PopupDetail) Utils.convertJsonStringToObject(jsonReq, PopupDetail.class);
            popupService.addPopupDetail(popupDetail);
            String response = String.format("Add new popupDetail successfully: %s", popupDetail);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (UtilsConverterException ex) {
            String errorMessage = String.format(CAN_NOT_CONVERT_OBJECT, jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot Add new PopupDetail: %s.", jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "detail/update")
    public ResponseEntity<String> updatePopupDetail(@RequestBody String jsonReq) {
        try {
            PopupDetail popupDetail = (PopupDetail) Utils.convertJsonStringToObject(jsonReq, PopupDetail.class);
            popupService.updatePopupDetail(popupDetail);
            String response = String.format("Update PopupDetail: %s completed.", popupDetail);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (UtilsConverterException ex) {
            String errorMessage = String.format(CAN_NOT_CONVERT_OBJECT, jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot update PopupDetail: %s.", jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("detail/{id}")
    public ResponseEntity<String> deletePopupDetail(@PathVariable Long id) {
        try {
            popupService.deletePopupDetail(id);
            String response = String.format("Delete PopupDetail Id: %d completed.", id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot delete PopupDetail Id: %d", id);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
