package com.lianyanjie.dubbo.dubbo2sellprovider.excpetion;

import com.lianyanjie.dubbo.dubbo2api.enums.ResultEnum;
import lombok.Getter;

/**
 * @author: lyj
 * @since: 2018/9/18
 */
@Getter
public class SellException  extends RuntimeException {

    private Integer code;

    public SellException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
    public SellException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
