package com.example.h_eruke;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@EnableAutoConfiguration
@EnableEurekaServer
@RestController
public class HErukeApplication {

    @RequestMapping("/test")
    public String home() {
        return "Hello world";
    }
    public static void main(String[] args) {
        SpringApplication.run(HErukeApplication.class, args);
    }

}
