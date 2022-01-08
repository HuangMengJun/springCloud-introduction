package com.example.h_pojo.controller;


import com.example.h_pojo.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    RedisTemplate redisTemplate;

    @RequestMapping("set")
    public void redisTest(){
        redisTemplate.opsForValue().set("xiaolan","小兰");
        System.out.println(redisTemplate.opsForValue().get("xiaolan"));
    }
}
