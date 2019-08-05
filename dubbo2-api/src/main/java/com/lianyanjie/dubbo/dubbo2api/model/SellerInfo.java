package com.lianyanjie.dubbo.dubbo2api.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 功能描述: 卖家端用户信息
 * @author: lyj
 * @since: 2018/12/20
 */

@Data
public class SellerInfo implements Serializable {


    private String sellerId;

    private String username;

    private String password;

    private String openId;
}
