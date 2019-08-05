package com.lianyanjie.dubbo.dubbo2api.service;

/**
 * 功能描述: 秒杀Service
 * @author: lyj
 * @since: 2018/12/20
 */
public interface SecKillService {

    /**
     * 查询商品信息
     * @param productId
     * @return
     */
    String querySecKillProductionInfo(String productId);


    /**
     * 秒杀活动：下单 减库存 结束活动
     */
    void orderProductMockDiffUser(String productId);
}
