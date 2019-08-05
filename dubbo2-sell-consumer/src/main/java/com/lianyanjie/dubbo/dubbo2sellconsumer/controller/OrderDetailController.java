package com.lianyanjie.dubbo.dubbo2sellconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lianyanjie.dubbo.dubbo2api.model.OrderDetail;
import com.lianyanjie.dubbo.dubbo2api.service.OrderDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: lyj
 * @since: 2019/8/5
 */
@RestController
@Slf4j
@RequestMapping("/order/detail")
public class OrderDetailController {

    @Reference(version = "1.0.0",url = "dubbo://127.0.0.1:20880")
    private OrderDetailService orderDetailService;

    @RequestMapping("/{orderId}")
    public List<OrderDetail> getByOrderId(@PathVariable("orderId")String orderId){
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderId(orderId);
        return orderDetailService.getByParam(orderDetail);
    }
}
