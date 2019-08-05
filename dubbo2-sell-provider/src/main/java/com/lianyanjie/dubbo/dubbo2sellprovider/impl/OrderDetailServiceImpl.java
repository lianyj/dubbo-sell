package com.lianyanjie.dubbo.dubbo2sellprovider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lianyanjie.dubbo.dubbo2api.model.OrderDetail;
import com.lianyanjie.dubbo.dubbo2api.service.OrderDetailService;
import com.lianyanjie.dubbo.dubbo2sellprovider.mapper.OrderDetailMapper;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: lyj
 * @since: 2019/8/5
 */
@Service(version = "1.0.0")
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public List<OrderDetail> getByParam(OrderDetail orderDetail){
        return orderDetailMapper.getByParam(orderDetail);
    }
}
