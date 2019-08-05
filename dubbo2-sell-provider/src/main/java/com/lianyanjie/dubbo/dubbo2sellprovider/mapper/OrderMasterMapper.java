package com.lianyanjie.dubbo.dubbo2sellprovider.mapper;

import com.lianyanjie.dubbo.dubbo2api.model.OrderMaster;
import org.apache.ibatis.annotations.Param;

/**
 * @author: lyj
 * @since: 2019/8/5
 */
public interface OrderMasterMapper {

    OrderMaster getByByOrderId(@Param("orderId") String orderId);

}
