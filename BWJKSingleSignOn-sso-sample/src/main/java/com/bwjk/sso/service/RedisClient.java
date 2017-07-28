package com.bwjk.sso.service;

/**
 * Created by ${符柱成} on 2017/3/31.
 */
public interface RedisClient {

    public <T> T get(String key,Class<T> resultType);
    public void set(String key, Object value);
    public boolean refreshExpire(String key, int second);
}
