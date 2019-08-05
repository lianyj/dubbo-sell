package com.lianyanjie.dubbo.dubbo2sellprovider.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lianyanjie.dubbo.dubbo2api.dto.OrderDTO;
import com.lianyanjie.dubbo.dubbo2api.enums.ResultEnum;
import com.lianyanjie.dubbo.dubbo2api.model.OrderDetail;
import com.lianyanjie.dubbo.dubbo2sellprovider.excpetion.SellException;
import com.lianyanjie.dubbo.dubbo2sellprovider.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: lyj
 * @since: 2018/9/19
 */
@Slf4j
public class OrderForm2OrderDTOConveter {

    public static OrderDTO convert(OrderForm orderForm){
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        List<OrderDetail> orderDetailList = new ArrayList<>();

        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>(){}.getType());
        } catch (Exception e) {
            log.error("【对象转换】错误， string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);
        return orderDTO;
    }
}
