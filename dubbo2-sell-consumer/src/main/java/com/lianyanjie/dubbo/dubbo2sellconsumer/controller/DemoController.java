package com.lianyanjie.dubbo.dubbo2sellconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lianyanjie.dubbo.dubbo2api.service.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @author: lyj
 * @since: 2019/3/7
 */
@RestController
public class DemoController {

    @Reference(version = "1.0.0",url = "dubbo://127.0.0.1:20880")
    private DemoService demoService;

    @RequestMapping("/hello")
    public String hello(@PathParam("msg") String msg){
        return demoService.hello(msg);
    }
}
