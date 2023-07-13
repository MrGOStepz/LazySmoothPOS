package com.lazysmooth.pos.controller;

import com.lazysmooth.pos.exception.LazySmoothException;
import com.lazysmooth.pos.exception.UtilsConverterException;
import com.lazysmooth.pos.model.db.OrderInfo;
import com.lazysmooth.pos.model.request.OrderRequest;
import com.lazysmooth.pos.model.response.OrderDetailInfoResponse;
import com.lazysmooth.pos.model.response.OrderResponse;
import com.lazysmooth.pos.service.OrderService;
import com.lazysmooth.pos.util.Utils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/v1/order")
public class OrderController extends AbstractController {
    private final OrderService orderService;
    static final String CAN_NOT_CONVERT_OBJECT = "Cannot convert Object from Request: %s.";

    @GetMapping(path = "/all")
    @ResponseBody
    public ResponseEntity<String> getAllOrderInfo() {
        try {
            List<OrderInfo> tableInfo = orderService.getOrderInfoAll();
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
    public ResponseEntity<String> getOrderInfoById(@PathVariable Long id) {
        try {
            OrderInfo orderInfo = orderService.getOrderInfoById(id);
            String response = Utils.convertJsonObjecToString(orderInfo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot Get TableInfo Id: %s.", id);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/add")
    @ResponseBody
    public ResponseEntity<String> addNewOrderInfo(@RequestBody String jsonReq) {
        try {
            OrderInfo orderInfo = (OrderInfo) Utils.convertJsonStringToObject(jsonReq, OrderInfo.class);
            orderInfo = orderService.addOrderInfo(orderInfo);
            String response = String.format("Add new orderInfo successfully: %s", orderInfo);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (UtilsConverterException ex) {
            String errorMessage = String.format(CAN_NOT_CONVERT_OBJECT, jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot Add new OrderInfo: %s.", jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "/update")
    public ResponseEntity<String> updateOrderInfo(@RequestBody String jsonReq) {
        try {
            OrderInfo orderInfo = (OrderInfo) Utils.convertJsonStringToObject(jsonReq, OrderInfo.class);
            orderService.updateOrderInfo(orderInfo);
            String response = String.format("Update OrderInfo: %s completed.", orderInfo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (UtilsConverterException ex) {
            String errorMessage = String.format(CAN_NOT_CONVERT_OBJECT, jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot update OrderInfo: %s.", jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOrderInfo(@PathVariable Long id) {
        try {
            orderService.deleteOrderInfo(id);
            String response = String.format("Delete OrderInfo Id: %d completed.", id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot delete OrderInfo Id: %d", id);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "detail/all")
    @ResponseBody
    public ResponseEntity<String> getAllOrderDetail() {
        try {
            List<OrderInfo> tableInfo = orderService.getOrderInfoAll();
            String response = Utils.convertJsonObjecToString(tableInfo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (LazySmoothException ex) {
            String errorMessage = "Cannot Get All TableInfo";
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "detail/{id}")
    @ResponseBody
    public ResponseEntity<String> getOrderDetailById(@PathVariable Long id) {
        try {
            OrderInfo orderInfo = orderService.getOrderInfoById(id);
            String response = Utils.convertJsonObjecToString(orderInfo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot Get TableInfo Id: %s.", id);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "detail/add")
    @ResponseBody
    public ResponseEntity<String> addNewOrderDetail(@RequestBody String jsonReq) {
        try {
            OrderInfo orderInfo = (OrderInfo) Utils.convertJsonStringToObject(jsonReq, OrderInfo.class);
            orderService.addOrderInfo(orderInfo);
            String response = String.format("Add new orderInfo successfully: %s", orderInfo);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (UtilsConverterException ex) {
            String errorMessage = String.format(CAN_NOT_CONVERT_OBJECT, jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot Add new OrderInfo: %s.", jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(path = "detail/update")
    public ResponseEntity<String> updateOrderDetail(@RequestBody String jsonReq) {
        try {
            OrderInfo orderInfo = (OrderInfo) Utils.convertJsonStringToObject(jsonReq, OrderInfo.class);
            orderService.updateOrderInfo(orderInfo);
            String response = String.format("Update OrderInfo: %s completed.", orderInfo);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (UtilsConverterException ex) {
            String errorMessage = String.format(CAN_NOT_CONVERT_OBJECT, jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot update OrderInfo: %s.", jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("detail/{id}")
    public ResponseEntity<String> deleteOrderDetail(@PathVariable Long id) {
        try {
            orderService.deleteOrderInfo(id);
            String response = String.format("Delete OrderDetail Id: %d completed.", id);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot delete OrderDetail Id: %d", id);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(path = "/order")
    @ResponseBody
    public ResponseEntity<String> addNewOrder(@RequestBody String jsonReq) {
        try {
            OrderRequest orderRequest = (OrderRequest) Utils.convertJsonStringToObject(jsonReq, OrderRequest.class);
            OrderInfo orderInfo = orderService.addOrder(orderRequest);
            String response = String.format("Add new order successfully: %s", orderInfo.toString());
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (UtilsConverterException ex) {
            String errorMessage = String.format(CAN_NOT_CONVERT_OBJECT, jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        } catch (LazySmoothException ex) {
            String errorMessage = String.format("Cannot Add new Order: %s.", jsonReq);
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/cook")
    @ResponseBody
    public ResponseEntity<String> getCookOrder() {
        try {
            List<OrderResponse> orderResponses = orderService.getListOrderCook();
            String response = Utils.convertJsonObjecToString(orderResponses);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (LazySmoothException ex) {
            String errorMessage = "Cannot get OrderInfo by Cook Status";
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/table/{tableName}")
    @ResponseBody
    public ResponseEntity<String> getOrderByTableName(@PathVariable String tableName) {
        try {
            OrderDetailInfoResponse orderDetailInfoResponses = orderService.getListOrderByTableName(tableName);
            String response = Utils.convertJsonObjecToString(orderDetailInfoResponses);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (LazySmoothException ex) {
            String errorMessage = "Cannot get OrderInfo by Cook Status";
            logError(errorMessage, ex.getMessage());
            return new ResponseEntity<>(generateErrorResponse(0, errorMessage, ex.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
