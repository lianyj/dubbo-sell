package com.lianyanjie.dubbo.dubbo2api.service;

import com.lianyanjie.dubbo.dubbo2api.model.OrderMaster;

/**
 * @author: lyj
 * @since: 2019/8/5
 */
public interface OrderMasterService {

    OrderMaster getByByOrderId(String orderId);
}
