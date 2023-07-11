package com.lazysmooth.pos.controller.websocket;

import com.lazysmooth.pos.model.db.OrderInfo;
import com.lazysmooth.pos.model.db.TableInfo;
import com.lazysmooth.pos.model.request.OrderRequest;
import com.lazysmooth.pos.model.request.TableStatusRequest;
import com.lazysmooth.pos.model.response.OrderResponse;
import com.lazysmooth.pos.service.OrderService;
import com.lazysmooth.pos.service.TableInfoService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class WebSocketController {
    private static final Logger logger = LogManager.getLogger(WebSocketController.class);
    private final OrderService orderService;
    private final TableInfoService tableInfoService;

    @MessageMapping("/cart/order")
    @SendTo("/topic/ordering")
    public OrderResponse ordering(OrderRequest orderRequest) {
        try {
            OrderInfo orderInfo = orderService.addOrder(orderRequest);
            OrderResponse orderResponse = new OrderResponse();
            orderResponse.setOrderInfoId(orderInfo.getId());
            orderResponse.setTableName(orderRequest.getTableName());
            orderResponse.setItems(orderRequest.getItems());
            return orderResponse;
        } catch (Exception ex) {
            return new OrderResponse();
        }
    }

    @MessageMapping("/table/update")
    @SendTo("/topic/table")
    public List<TableInfo> tableStatus(TableStatusRequest request) {
        List<TableInfo> tableInfoList = new ArrayList<>();
        try {
            tableInfoService.updateStatus(request.getStatus(), request.getName());
            tableInfoList = tableInfoService.getAll();
            return tableInfoList;
        } catch (Exception ex) {
            return tableInfoList;
        }
    }
}
