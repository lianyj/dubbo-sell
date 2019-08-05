package com.lianyanjie.dubbo.dubbo2sellprovider.form;

import lombok.Data;

/**
 * @author: lyj
 * @since: 2018/9/19
 */
@Data
public class CategoryForm {


    private Integer categoryId;

    /** 类目名字. */
    private String categoryName;

    /** 类目编号. */
    private Integer categoryType;
}
