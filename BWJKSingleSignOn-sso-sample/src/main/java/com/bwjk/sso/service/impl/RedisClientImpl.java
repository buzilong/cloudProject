package com.bwjk.sso.service.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.bwjk.sso.service.RedisClient;

/**
 * 
 * @author buzl
 *
 */
@Service
public class RedisClientImpl implements RedisClient {

    
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @SuppressWarnings("unchecked")
	@Override
    public  <T> T get(String key,Class<T> resultType) {
        return (T) redisTemplate.opsForValue().get(key);
    }

    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    @Override
    public boolean refreshExpire(String key, int second) {
        return redisTemplate.expire(key, second, TimeUnit.SECONDS);
    }


}