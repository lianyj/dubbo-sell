package com.lianyanjie.dubbo.dubbo2sellprovider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lianyanjie.dubbo.dubbo2api.service.DemoService;

/**
 * @author: lyj
 * @since: 2019/3/7
 */
@Service(version = "1.0.0")
public class DemoServiceImpl implements DemoService {


    @Override
    public String hello(String message) {
        return String.format("hello,%s",message);
    }
}
