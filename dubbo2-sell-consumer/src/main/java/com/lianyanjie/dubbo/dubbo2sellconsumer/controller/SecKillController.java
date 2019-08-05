package com.lianyanjie.dubbo.dubbo2sellconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lianyanjie.dubbo.dubbo2api.service.SecKillService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: lyj
 * @since: 2018/12/20
 */
@RestController
@Slf4j
@RequestMapping("/skill")
public class SecKillController {

    @Reference(version = "1.0.0",url = "dubbo://127.0.0.1:20880")
    private SecKillService secKillService;

    /**
     * 查询秒杀活动特价商品的信息
     * @param productId
     * @return
     * @throws Exception
     */
    @GetMapping("/query/{productId}")
    public String query(@PathVariable String productId){
        return secKillService.querySecKillProductionInfo(productId);
    }

    @GetMapping("/order/{productId}")
    public String skill(@PathVariable String productId){
        log.info("@skill request,productId :" +productId);
        secKillService.orderProductMockDiffUser(productId);
        return secKillService.querySecKillProductionInfo(productId);
    }

}
