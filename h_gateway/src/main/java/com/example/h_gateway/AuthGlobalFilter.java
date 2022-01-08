package com.example.h_gateway;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: hmj
 * @createDate: 2022/1/27
 * @description: 校验用户登录
 */
public class AuthGlobalFilter implements GlobalFilter, Ordered {

    @Autowired
    RedisTemplate redisTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        String token  = exchange.getRequest().getQueryParams().getFirst("access-token");
//        if(StringUtils.isEmpty(token)){
//            if(exchange.getRequest().getPath().toString().equals("/consumer-service//user/checkUser")){
//                return  chain.filter(exchange);
//            }else{
//                return this.notPower(exchange);
//            }
//        }else{
//            System.out.println("该用户已经登录");
//            return  chain.filter(exchange);
//        }
        return  chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 1;
    }

    private Mono<Void> notPower(ServerWebExchange serverWebExchange) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("code",400);
        resultMap.put("msg","当前用户未登录");
        serverWebExchange.getResponse().setStatusCode(HttpStatus.NOT_FOUND);
        DataBuffer buffer = serverWebExchange.getResponse().bufferFactory().wrap(resultMap.toString().getBytes(StandardCharsets.UTF_8));
        ServerHttpResponse response = serverWebExchange.getResponse();
        response.setStatusCode(HttpStatus.NOT_FOUND);
        response.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        return response.writeWith(Mono.just(buffer));
    }


}
