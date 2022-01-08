package com.example.h_consumer.controller;

import com.example.h_consumer.client.UserClient;
import com.example.h_pojo.entity.User;
import com.example.h_pojo.param.UserParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserClient userClient;

    @RequestMapping(value="/checkUser",method= RequestMethod.POST)
    public Map<String,Object> checkUser(@RequestBody  UserParam userParam){
        log.debug("收到用户参数:{}，用户密码{}",userParam);
        return userClient.checkUser(userParam);
    }
    @RequestMapping(value="/getUserList",method= RequestMethod.GET)
    public List<User> getUserList(){
        return userClient.getUser();
    }
}
