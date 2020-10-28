package com.example.spring.demo;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class TestRedis {
    @Autowired
    RedisTemplate redisTemplate;
    @Test
    public void a() {
        Object a = redisTemplate.opsForValue().get("a");
        System.out.println(a);
    }
}
