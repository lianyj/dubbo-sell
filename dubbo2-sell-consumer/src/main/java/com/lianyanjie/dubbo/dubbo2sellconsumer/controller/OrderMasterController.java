package com.lianyanjie.dubbo.dubbo2sellconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.lianyanjie.dubbo.dubbo2api.model.OrderMaster;
import com.lianyanjie.dubbo.dubbo2api.service.OrderMasterService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lyj
 * @since: 2019/8/5
 */
@RestController
@RequestMapping("/order/master")
public class OrderMasterController {

    @Reference(version = "1.0.0",url = "dubbo://127.0.0.1:20880")
    private OrderMasterService orderMasterService;

    @RequestMapping("/{orderId}")
    public OrderMaster getByOrderId(@PathVariable("orderId") String orderId){
        return orderMasterService.getByByOrderId(orderId);
    }

}
