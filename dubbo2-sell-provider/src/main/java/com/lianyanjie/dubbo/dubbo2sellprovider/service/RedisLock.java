package com.lianyanjie.dubbo.dubbo2sellprovider.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * redis 分布式锁
 * @author: lyj
 * @since: 2018/12/20
 */

@Slf4j
@Component
public class RedisLock {


    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 加锁
     * @param key productId
     * @param value 当前时间+超时时间
     * @return
     */
    public boolean lock(String key, String value){
        // setIfAbset() 等同于 Redis 命令：SETNX
        if(redisTemplate.opsForValue().setIfAbsent(key,value)){
            return true;
        }

        String currentValue = redisTemplate.opsForValue().get(key);
        // 如果锁过期
        if(!StringUtils.isEmpty(currentValue) && Long.parseLong(currentValue)<System.currentTimeMillis()){
            //获取上一个锁的时间
            // getAndSet 等同于 Redis 命令：GETSET
            String oldValue = redisTemplate.opsForValue().getAndSet(key,value);
            if(!StringUtils.isEmpty(oldValue) && oldValue.equals(currentValue)){
                return  true;
            }
        }
        return false;
    }

    /**
     * 解锁：删掉key
     * @param key
     * @param value
     */
    public void unlock(String key,String value){
        try{
            String currentValue = redisTemplate.opsForValue().get(key);
            if(!StringUtils.isEmpty(currentValue) && currentValue.equals(value)){
                redisTemplate.opsForValue().getOperations().delete(key);
            }
        }catch (Exception e){
            log.error("【redis分布式锁】解锁异常, {}", e);
        }
    }
}
