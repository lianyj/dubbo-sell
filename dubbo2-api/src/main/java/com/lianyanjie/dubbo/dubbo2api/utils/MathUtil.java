package com.lianyanjie.dubbo.dubbo2api.utils;

/**
 * 功能描述: 数学工具类
 * @author: lyj
 * @since: 2018/10/8
 */
public class MathUtil {

    private static final Double MONEY_RANGE = 0.01;

    /**
     * 功能描述: 比较两个金额是否相等（相减绝对值小于0.01认定相等）
     * <p>
     * 作者: luohongquan
     * 日期: 2018/5/7 0007 16:05
     */
    public static Boolean equals(Double d1,Double d2){
        Double result = Math.abs(d1-d2);
        if(result<MONEY_RANGE){
            return true;
        }else {
            return false;
        }
    }


}
