//package com.lazysmooth.pos.controller.websocket;
//import com.mrgostepz.smooth.model.db.OrderInfo;
//import com.mrgostepz.smooth.model.db.TableInfo;
//import com.mrgostepz.smooth.model.request.OrderRequest;
//import com.mrgostepz.smooth.model.request.TableStatusRequest;
//import com.mrgostepz.smooth.model.response.OrderResponse;
//import com.mrgostepz.smooth.service.OrderService;
//import com.mrgostepz.smooth.service.TableInfoService;
//import lombok.RequiredArgsConstructor;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Controller;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RequiredArgsConstructor
//@Controller
//public class WebSocketController {
//    private static final Logger logger = LogManager.getLogger(WebSocketController.class);
//    private final OrderService orderService;
//    private final TableInfoService tableInfoService;
//
//    @MessageMapping("/cart/order")
//    @SendTo("/topic/ordering")
//    public OrderResponse ordering(OrderRequest orderRequest) {
//        try {
//            OrderInfo orderInfo = orderService.addOrder(orderRequest);
//            OrderResponse orderResponse = new OrderResponse();
//            orderResponse.setOrderInfoId(orderInfo.getId());
//            orderResponse.setTableName(orderRequest.getTableName());
//            orderResponse.setItems(orderRequest.getCartItems());
////            TableStatusRequest tableStatusRequest = new TableStatusRequest();
////            tableStatusRequest.setName(orderRequest.getTableName());
////            tableStatusRequest.setStatus("Cook");
////            tableStatus(tableStatusRequest);
//            return orderResponse;
//        } catch (Exception ex) {
//            return new OrderResponse();
//        }
//    }
//
//    @MessageMapping("/table/update")
//    @SendTo("/topic/table")
//    public List<TableInfo> tableStatus(TableStatusRequest request) {
//        List<TableInfo> tableInfoList = new ArrayList<>();
//        try {
//            tableInfoService.updateTableInfoStatusByName(request.getStatus(), request.getName());
//            tableInfoList = tableInfoService.getAll();
//            return tableInfoList;
//        } catch (Exception ex) {
//            return tableInfoList;
//        }
//    }
//
//    @MessageMapping("/kitchen/update")
//    @SendTo("/topic/kitchen")
//    public List<TableInfo> kitchenOrder(TableStatusRequest request) {
//        List<TableInfo> tableInfoList = new ArrayList<>();
//        try {
//            tableInfoService.updateTableInfoStatusByName(request.getStatus(), request.getName());
//            tableInfoList = tableInfoService.getAll();
//            return tableInfoList;
//        } catch (Exception ex) {
//            return tableInfoList;
//        }
//    }
//
//}
