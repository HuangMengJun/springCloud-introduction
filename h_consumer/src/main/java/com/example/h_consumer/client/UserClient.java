package com.example.h_consumer.client;

import com.example.h_pojo.entity.User;
import com.example.h_pojo.param.UserParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name="PROVIDER")
public interface UserClient {

    @RequestMapping(method = RequestMethod.POST,value = "/user/findByName",consumes = "application/json")
    Map<String,Object> checkUser(UserParam param);

    @RequestMapping(method = RequestMethod.GET,value = "/user/loadUserList")
    List<User> getUser();
}
