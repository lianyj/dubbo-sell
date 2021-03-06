package com.lianyanjie.dubbo.dubbo2api.dto;

import lombok.Data;

/**
 * 购物车
 * @author: lyj
 * @since: 2018/9/18
 */
@Data
public class CartDTO {

    /** 商品Id */
    private String productId;

    /** 商品数量 */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
