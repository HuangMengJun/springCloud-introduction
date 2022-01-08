package com.example.h_provider.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rout")
public class TestController {


    @RequestMapping("/test")
    public String test(){
        return "sx";
    }
}
