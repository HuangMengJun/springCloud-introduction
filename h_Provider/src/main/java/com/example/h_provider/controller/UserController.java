package com.example.h_provider.controller;

import com.example.h_pojo.entity.User;
import com.example.h_pojo.param.UserParam;
import com.example.h_provider.dao.UserMapper;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.cert.ocsp.Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    private static  InheritableThreadLocal<Map>  userSession  = new InheritableThreadLocal<Map>();
    private  Map<String,Object> resultMap=null;

    @Autowired
    UserMapper userDao;

    @RequestMapping(value="/findByName",method= RequestMethod.POST)
    public Map<String,Object> checkUser( @RequestBody UserParam userParam){
        log.info("收到用户参数:{}，用户密码{}",userParam);
        User user = userDao.findByName(userParam.getName());
        Map<String,Object> userMap = new HashMap<>();
        String openId=UUID.randomUUID().toString();
        userMap.put(openId,user);
        userSession.set(userMap);
        resultMap=new HashMap<>();
        resultMap.put("code",0);
        resultMap.put("msg",user);
        resultMap.put("openId",openId);
        return resultMap;
    }

    @RequestMapping(value = "/loadUserList",method = RequestMethod.GET)
    public List<User> loadUserList(){
        return userDao.findByUser();
    }

    @RequestMapping("/")
    public String test(){
        return "test";
    }
}
