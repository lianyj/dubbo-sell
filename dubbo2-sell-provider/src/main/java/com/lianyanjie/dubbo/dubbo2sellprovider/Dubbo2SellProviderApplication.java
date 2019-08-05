package com.lianyanjie.dubbo.dubbo2sellprovider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.lianyanjie"})
@MapperScan(basePackages = {"com.lianyanjie.dubbo.dubbo2sellprovider.mapper"})
public class Dubbo2SellProviderApplication {


    public static void main(String[] args) {
        SpringApplication.run(Dubbo2SellProviderApplication.class, args);
    }

}
