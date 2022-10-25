package com.ankang.drugs.gateway.auth;

import com.alibaba.cloud.commons.lang.StringUtils;
import com.alibaba.fastjson.JSON;
import com.ankang.drugs.gateway.respone.ResponseCodeEnum;
import com.ankang.drugs.gateway.respone.ResponseResult;
import com.ankang.drugs.gateway.respone.TokenAuthenticationException;
import com.ankang.drugs.gateway.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class TokenFilter implements GlobalFilter, Ordered {

    final static String TOKEN = "token";
    @Value("${secretKey:123456}")
    private String secretKey;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest serverHttpRequest = exchange.getRequest();
        ServerHttpResponse serverHttpResponse = exchange.getResponse();
        String uri = serverHttpRequest.getURI().getPath();

        //  检查白名单（配置）
        if (uri.contains("/auth/login")) {
            return chain.filter(exchange);
        }

        String token = serverHttpRequest.getHeaders().getFirst("Authorization");
        if (StringUtils.isBlank(token)) {
            serverHttpResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
            return getVoidMono(serverHttpResponse, ResponseCodeEnum.TOKEN_MISSION);
        }

        String userId = JWTUtil.getUserId(token);
        if (userId == null) {
            return getVoidMono(serverHttpResponse, ResponseCodeEnum.TOKEN_INVALID);
        }

        // 检查Redis中是否有此Token(退出登录有删除token)
        HashOperations<String, String, String> hashOperations = stringRedisTemplate.opsForHash();
        String redisToken = hashOperations.get(userId, TOKEN);
        if (!token.equals(redisToken)) {
            return getVoidMono(serverHttpResponse, ResponseCodeEnum.TOKEN_INVALID);
        }

        try {
            JWTUtil.verifyToken(token, secretKey);
        } catch (TokenAuthenticationException ex) {
            return getVoidMono(serverHttpResponse, ResponseCodeEnum.TOKEN_INVALID);
        } catch (Exception ex) {
            return getVoidMono(serverHttpResponse, ResponseCodeEnum.UNKNOWN_ERROR);
        }


        ServerHttpRequest mutableReq = serverHttpRequest.mutate().header("userId", userId).build();
        ServerWebExchange mutableExchange = exchange.mutate().request(mutableReq).build();
        ServerHttpRequest req = exchange.getRequest().mutate()
                .header("systemFrom", "gateway").build();
        return chain.filter(mutableExchange);

    }

    private Mono<Void> getVoidMono(ServerHttpResponse serverHttpResponse, ResponseCodeEnum responseCodeEnum) {
        serverHttpResponse.getHeaders().add("Content-Type", "application/json;charset=UTF-8");
        ResponseResult responseResult = ResponseResult.error(responseCodeEnum.getCode(), responseCodeEnum.getMessage());
        DataBuffer dataBuffer = serverHttpResponse.bufferFactory().wrap(JSON.toJSONString(responseResult).getBytes());
        return serverHttpResponse.writeWith(Flux.just(dataBuffer));
    }

    @Override
    public int getOrder() {
        return -100;
    }
}