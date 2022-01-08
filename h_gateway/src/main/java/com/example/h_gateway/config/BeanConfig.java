package com.example.h_gateway.config;

import com.example.h_gateway.AuthGlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {


    @Bean
    public AuthGlobalFilter authGlobalFilter(){
        return new AuthGlobalFilter();
    }
}
