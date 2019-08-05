package com.lianyanjie.dubbo.dubbo2sellprovider.converter;

import com.lianyanjie.dubbo.dubbo2api.dto.OrderDTO;
import com.lianyanjie.dubbo.dubbo2api.model.OrderMaster;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 功能描述: OrderMaster转成OrderDTO
 * @author: lyj
 * @since: 2018/9/19
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster){
        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster,orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        return orderMasterList.stream().map(e->convert(e)).collect(Collectors.toList());
    }
}
