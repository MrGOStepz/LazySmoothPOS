package com.lazysmooth.pos.service;


import com.lazysmooth.pos.db.repository.OrderDetailRepository;
import com.lazysmooth.pos.db.repository.OrderInfoRepository;
import com.lazysmooth.pos.exception.LazySmoothException;
import com.lazysmooth.pos.model.CartItem;
import com.lazysmooth.pos.model.ReceiptInfo;
import com.lazysmooth.pos.model.db.OrderDetail;
import com.lazysmooth.pos.model.db.OrderInfo;
import com.lazysmooth.pos.model.db.Product;
import com.lazysmooth.pos.model.enums.OrderType;
import com.lazysmooth.pos.model.enums.Status;
import com.lazysmooth.pos.model.request.OrderRequest;
import com.lazysmooth.pos.model.response.OrderDetailInfoResponse;
import com.lazysmooth.pos.model.response.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private static final Logger logger = LogManager.getLogger(OrderService.class);

    private final OrderInfoRepository orderInfoRepository;
    private final OrderDetailRepository orderDetailRepository;
    private final ProductService productService;

    public List<OrderInfo> getOrderInfoAll() {
        try {
            List<OrderInfo> orderInfoList = orderInfoRepository.findAll();
            logger.debug("Get All OrderInfo: {}", orderInfoList);
            return orderInfoList;
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }

    public OrderInfo getOrderInfoById(Long id) {
        try {
            Optional<OrderInfo> opt = orderInfoRepository.findById(id);
            OrderInfo orderInfo = opt.orElseGet(OrderInfo::new);
            logger.debug("Get OrderInfo: {}", orderInfo);
            return orderInfo;
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }

    public OrderInfo addOrderInfo(OrderInfo orderInfo) {
        try {
            var retObject = orderInfoRepository.save(orderInfo);
            orderInfoRepository.flush();
            orderInfo.setId(retObject.getId());
            logger.info("Add new OrderInfo: {} \nSuccessfully.", orderInfo);
            return orderInfo;
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }

    }

    public void updateOrderInfo(OrderInfo orderInfo) {
        try {
            orderInfoRepository.save(orderInfo);
            logger.info("Updated OrderInfo: {}. Successfully", orderInfo);
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }

    public void deleteOrderInfo(Long id) {
        try {
            orderInfoRepository.deleteById(id);
            logger.info("Deleted OrderInfo: {} Successfully.", id);
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }

    public List<OrderDetail> getOrderDetailAll() {
        try {
            List<OrderDetail> orderDetailList = orderDetailRepository.findAll();
            logger.debug("Get All OrderDetail: {}", orderDetailList);
            return orderDetailList;
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }

    public OrderDetail getOrderDetailById(Long id) {
        try {
            Optional<OrderDetail> opt = orderDetailRepository.findById(id);
            OrderDetail orderDetail = opt.orElseGet(OrderDetail::new);
            logger.debug("Get OrderDetail: {}", orderDetail);
            return orderDetail;
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }

    public OrderDetail addOrderDetail(OrderDetail orderDetail) {
        try {
            var retObject = orderDetailRepository.save(orderDetail);
            orderDetailRepository.flush();
            orderDetail.setId(retObject.getId());
            logger.info("Add new OrderDetail: {} \nSuccessfully.", orderDetail);
            return orderDetail;
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }

    }

    public void updateOrderDetail(OrderDetail orderDetail) {
        try {
            orderDetailRepository.save(orderDetail);
            logger.info("Updated OrderDetail: {}. Successfully", orderDetail);
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }

    public void deleteOrderDetail(Long id) {
        try {
            orderDetailRepository.deleteById(id);
            logger.info("Deleted OrderDetail: {} Successfully.", id);
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }

    public OrderInfo addOrder(OrderRequest orderRequest) {
        try {
            List<OrderDetail> orderDetailList = generateOrderDetail(orderRequest);
            OrderInfo orderInfo = generateOrderInfo(orderDetailList, orderRequest.getTableName());
            var retObject = orderInfoRepository.save(orderInfo);
            orderInfoRepository.flush();
            orderInfo.setId(retObject.getId());
            for (OrderDetail order : orderDetailList) {
                order.setOrderInfoId(orderInfo.getId());
                orderDetailRepository.save(order);
            }
            return orderInfo;
        } catch (Exception ex) {
            throw new LazySmoothException(ex.getMessage());
        }
    }

    public List<OrderResponse> getListOrderCook() {
        try {
            List<OrderInfo> orderInfoList;
            List<OrderResponse> orderResponseList = new ArrayList<>();
            List<OrderDetail> orderDetailList;
            OrderResponse orderResponse;
            orderInfoList = orderInfoRepository.findByStatus(Status.COOK.getValueString());
            for (OrderInfo orderInfo : orderInfoList) {
                orderDetailList = orderDetailRepository.findByOrderInfoId(orderInfo.getId());
                List<CartItem> cartItemList = new ArrayList<>();
                orderResponse = new OrderResponse();
                orderResponse.setOrderInfoId(orderInfo.getId());
                orderResponse.setTableName(orderInfo.getTableName());
                for (OrderDetail orderDetail : orderDetailList) {
                    CartItem cartItem = new CartItem();
                    Product tempProduct = productService.getProductByCache(orderDetail.getProductId());
                    orderDetail.setProductName(tempProduct.getName());
                    cartItem.setProductId(orderDetail.getProductId());
                    cartItem.setPopupDetailId(orderDetail.getPopupDetailId());
                    cartItem.setName(orderDetail.getProductName());
                    cartItem.setQuantity(orderDetail.getQuantity());
                    cartItem.setPrice(orderDetail.getPrice());
                    cartItem.setComment(orderDetail.getComment());
                    cartItemList.add(cartItem);
                }
                orderResponse.setItems(cartItemList);
                orderResponseList.add(orderResponse);
            }
            return orderResponseList;

        } catch (Exception ex) {
            return new ArrayList<>();
        }
    }

    public OrderDetailInfoResponse getListOrderByTableName(String tableName) {
        try {
            List<OrderInfo> orderInfoList = orderInfoRepository.findByTableName(tableName);
            List<Long> idList  = orderInfoList.stream().map(OrderInfo::getId).toList();
            List<OrderDetail> orderDetailList = orderDetailRepository.findByOrderInfoIdIn(idList);
            OrderDetailInfoResponse orderResponse = new OrderDetailInfoResponse();
            orderResponse.setOrderInfoList(orderInfoList);
            orderResponse.setOrderDetailList(orderDetailList);
            return orderResponse;
        } catch (Exception ex) {
            return new OrderDetailInfoResponse();
        }
    }

    private List<OrderDetail> generateOrderDetail(OrderRequest orderRequest) {
        List<OrderDetail> orderDetailList = new ArrayList<>();
        Timestamp dateTimeNow = new Timestamp(System.currentTimeMillis());
        for (CartItem cartItem : orderRequest.getItems()) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProductId(cartItem.getProductId());
            orderDetail.setPopupDetailId(cartItem.getPopupDetailId());
            orderDetail.setProductName(cartItem.getName());
            orderDetail.setQuantity(cartItem.getQuantity());
            orderDetail.setComment(cartItem.getComment());
            orderDetail.setPrice(cartItem.getPrice());
            orderDetail.setStatus(Status.COOK.getValueString());
            orderDetail.setStartedTime(dateTimeNow);
            orderDetail.setLastUpdatedTime(dateTimeNow);
            orderDetailList.add(orderDetail);
        }
        return orderDetailList;
    }

    private OrderInfo generateOrderInfo(List<OrderDetail> orderDetails, String tableName) {
        OrderInfo order = new OrderInfo();
        ReceiptInfo receiptInfo = new ReceiptInfo();
        Double amount = 0.0;
        Timestamp dateTimeNow = new Timestamp(System.currentTimeMillis());
        receiptInfo.setOrderDetails(orderDetails);
        order.setTableName(tableName);
        order.setOrderType(OrderType.DINE_IN.getValueString());
        order.setStatus(Status.COOK.getValueString());
        order.setReceiptJson(receiptInfo.toString());
        order.setStartedTime(dateTimeNow);
        order.setLastUpdatedTime(dateTimeNow);
        for (OrderDetail orderDetail : orderDetails) {
            amount += orderDetail.getPrice();
        }
        order.setAmount(amount);
        return order;
    }
}

