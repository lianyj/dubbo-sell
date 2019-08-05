package com.lianyanjie.dubbo.dubbo2api.model;

import com.lianyanjie.dubbo.dubbo2api.enums.ProductStatusEnum;
import com.lianyanjie.dubbo.dubbo2api.utils.EnumUtil;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: lyj
 * @since: 2018/9/14
 */
@Data
public class ProductInfo implements Serializable {

    private static final long serialVersionUID = -2691102804444440046L;

    private String productId;

    /** 名字 */
    private String productName;

    /** 单价 */
    private BigDecimal productPrice;

    /** 库存 */
    private Integer productStock;

    /** 描述 */
    private String productDescription;

    /** 小图 */
    private String productIcon;

    /** 状态，0：正常，1：下架 */
    private Integer productStatus = ProductStatusEnum.UP.getCode();

    /** 类目编号 */
    private Integer categoryType;

    private Date createTime;
    private Date updateTime;


    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(productStatus, ProductStatusEnum.class);
    }

}
