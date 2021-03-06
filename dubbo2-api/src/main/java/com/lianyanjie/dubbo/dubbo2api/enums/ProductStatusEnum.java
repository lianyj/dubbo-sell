package com.lianyanjie.dubbo.dubbo2api.enums;

import lombok.Getter;

/**
 * @author: lyj
 * @since: 2018/9/14
 */
@Getter
public enum ProductStatusEnum implements CodeEnum {

    UP(0, "在架"),
    DOWN(1, "下架");

    private Integer code;
    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
