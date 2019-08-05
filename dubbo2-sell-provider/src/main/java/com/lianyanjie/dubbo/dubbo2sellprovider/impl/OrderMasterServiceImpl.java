package com.lianyanjie.dubbo.dubbo2sellprovider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lianyanjie.dubbo.dubbo2api.model.OrderMaster;
import com.lianyanjie.dubbo.dubbo2api.service.OrderMasterService;
import com.lianyanjie.dubbo.dubbo2sellprovider.mapper.OrderMasterMapper;

import javax.annotation.Resource;

/**
 * @author: lyj
 * @since: 2019/8/5
 */
@Service(version = "1.0.0")
public class OrderMasterServiceImpl implements OrderMasterService {

    @Resource
    private OrderMasterMapper orderMasterMapper;

    @Override
    public OrderMaster getByByOrderId(String orderId) {
        return orderMasterMapper.getByByOrderId(orderId);
    }
}
