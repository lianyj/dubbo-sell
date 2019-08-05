package com.lianyanjie.dubbo.dubbo2sellprovider.mapper;

import com.lianyanjie.dubbo.dubbo2api.model.OrderDetail;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: lyj
 * @since: 2019/8/5
 */
public interface OrderDetailMapper {

    int insert(OrderDetail orderDetail);

    List<OrderDetail> getByParam(@Param("search")OrderDetail orderDetail);

}
