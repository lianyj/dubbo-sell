package com.lianyanjie.dubbo.dubbo2api.dto;

import com.lianyanjie.dubbo.dubbo2api.enums.OrderStatusEnum;
import com.lianyanjie.dubbo.dubbo2api.enums.PayStatusEnum;
import com.lianyanjie.dubbo.dubbo2api.model.OrderDetail;
import com.lianyanjie.dubbo.dubbo2api.utils.EnumUtil;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 订单（数据传输对象）
 * @author: lyj
 * @since: 2018/9/18
 */
@Data
public class OrderDTO {

    /** 订单id */
    private String orderId;

    /** 买家名字 */
    private String buyerName;

    /** 买家电话 */
    private String buyerPhone;

    /** 买家地址 */
    private String buyerAddress;

    /** 买家微信openid */
    private String buyerOpenid;

    /** 订单总金额 */
    private BigDecimal orderAmount;

    /** 订单状态，0：新下单（默认）1：已完成 2：取消 */
    private Integer orderStatus;

    /** 支付状态，0：未支付（默认）1：已支付 */
    private Integer payStatus;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

    // 订单详情列表
    private List<OrderDetail> orderDetailList;

    private Integer currentPage;


    public OrderStatusEnum getOrderStatusEnum() {
        return EnumUtil.getByCode(orderStatus, OrderStatusEnum.class);
    }

    public PayStatusEnum getPayStatusEnum() {
        return EnumUtil.getByCode(payStatus, PayStatusEnum.class);
    }
}
