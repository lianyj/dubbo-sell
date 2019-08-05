package com.lianyanjie.dubbo.dubbo2api.service;

import com.lianyanjie.dubbo.dubbo2api.model.OrderDetail;

import java.util.List;

/**
 * @author: lyj
 * @since: 2019/8/5
 */
public interface OrderDetailService {

   List<OrderDetail> getByParam(OrderDetail orderDetail);
}
