package com.lianyanjie.dubbo.dubbo2api.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: lyj
 * @since: 2018/9/13
 */

@Data
public class ProductCategory implements Serializable {


    /** 类目ID */
    private Integer categoryId;

    /** 类目名字 */
    private String categoryName;

    /** 类目编号 */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    public ProductCategory() {

    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName = categoryName;
        this.categoryType = categoryType;
    }
}





