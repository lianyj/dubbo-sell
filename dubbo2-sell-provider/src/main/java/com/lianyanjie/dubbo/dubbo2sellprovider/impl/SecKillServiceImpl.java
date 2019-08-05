package com.lianyanjie.dubbo.dubbo2sellprovider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lianyanjie.dubbo.dubbo2api.service.SecKillService;
import com.lianyanjie.dubbo.dubbo2api.utils.KeyUtil;
import com.lianyanjie.dubbo.dubbo2sellprovider.excpetion.SellException;
import com.lianyanjie.dubbo.dubbo2sellprovider.service.RedisLock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: lyj
 * @since: 2019/3/7
 */
@Service(version = "1.0.0")
public class SecKillServiceImpl implements SecKillService {

    //超时时间 10s
    private static final int TIMEOUT = 10*1000;

    @Autowired
    private RedisLock redisLock;

    /** 国庆活动，皮蛋粥特价，限量100000份 */
    static Map<String, Integer> products;
    static Map<String, Integer> stock;
    static Map<String, String> orders;

    static {
        /** 模拟多个表：商品信息表，库存表，秒杀成功订单表 */
        products = new HashMap<>();
        stock = new HashMap<>();
        orders = new HashMap<>();
        products.put("123456",1000); // 商品Id, 商品库存
        stock.put("123456",1000);

    }

    private String queryMap(String productId){
        return "国庆活动，皮蛋粥特价，限量份"
                + products.get(productId)
                + " 还剩：" + stock.get(productId) + "份"
                + " 该商品成功下单用户数目："
                + orders.size() + " 人";
    }


    /**
     * 查询商品信息
     * @param productId
     * @return
     */
    @Override
    public String querySecKillProductionInfo(String productId) {
        return this.queryMap(productId);
    }


    /**
     * 秒杀活动：下单 减库存 结束活动
     */
    @Override
    public void orderProductMockDiffUser(String productId) {

        //加锁
        long time = System.currentTimeMillis() + TIMEOUT;

        // 如果加锁不成功, lock()返回false
        if(!redisLock.lock(productId,String.valueOf(time))){
            throw new SellException(101, "哎呦喂，人也太多了，换个姿势再试试~~~");
        }
        // 1. 查询该商品库存，为0则结束活动
        int stockNum = stock.get(productId);
        if(stockNum == 0){
            throw new SellException(100, "活动结束");
        }else {
            // 2. 下单(模拟不同用户openid不同)
            orders.put(KeyUtil.genUniqueKey(),productId);
            // 3. 减库存
            stockNum = stockNum -1;
            try {
                Thread.sleep(100);
            }catch (Exception e){
                e.printStackTrace();
            }
            stock.put(productId,stockNum);
        }

        // 解锁
        redisLock.unlock(productId,String.valueOf(time));


    }
}
