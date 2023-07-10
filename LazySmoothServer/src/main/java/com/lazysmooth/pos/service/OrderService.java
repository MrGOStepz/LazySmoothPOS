package com.lazysmooth.pos.service;


import com.lazysmooth.pos.db.repository.OrderDetailRepository;
import com.lazysmooth.pos.db.repository.OrderInfoRepository;
import com.lazysmooth.pos.exception.LazySmoothException;
import com.lazysmooth.pos.model.db.OrderDetail;
import com.lazysmooth.pos.model.db.OrderInfo;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private static final Logger logger = LogManager.getLogger(OrderService.class);

    private final OrderInfoRepository orderInfoRepository;
    private final OrderDetailRepository orderDetailRepository;

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
}

