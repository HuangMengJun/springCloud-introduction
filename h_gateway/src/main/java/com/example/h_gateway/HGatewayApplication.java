package com.example.h_gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class HGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(HGatewayApplication.class, args);
    }
}
