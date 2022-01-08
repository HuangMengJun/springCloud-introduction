package com.example.h_provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableEurekaClient
@RestController
@MapperScan(basePackages = {"com.example.h_provider.dao"})
public class HProviderApplication {
    @RequestMapping("/test")
    public String home() {
        return "Hello world";
    }
    public static void main(String[] args) {
        SpringApplication.run(HProviderApplication.class, args);
    }

}
