package com.lazysmooth.pos.model.response;

import com.lazysmooth.pos.model.db.OrderDetail;
import com.lazysmooth.pos.model.db.OrderInfo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class OrderDetailInfoResponse {
   private List<OrderInfo> orderInfoList = new ArrayList<>();
   private List<OrderDetail> orderDetailList = new ArrayList<>();
}
