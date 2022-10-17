package com.ankang.user.annotation;

import com.alibaba.fastjson2.JSON;
import com.ankang.cache.FullConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Log4j2
@RequiredArgsConstructor
public class RedisAspect {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Pointcut("@annotation(com.ankang.user.annotation.AutowireRedis)")
    public void pointCut() {
    }


    @Around("pointCut()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        // 拿到类+方法 -> 类-方法
        Signature signature = proceedingJoinPoint.getSignature();
        String useFunctionKey = signature.getDeclaringType().getSimpleName() + "-" + signature.getName();
        String value = stringRedisTemplate.opsForValue().get(useFunctionKey);
        if (value == null || value.equals("") || value.equals("null")) {
            log.info("redis中没有Key是 -----> [{}]的数据", useFunctionKey);
            try {
                String proceed = JSON.toJSONString(proceedingJoinPoint.proceed());
                stringRedisTemplate.opsForValue().set(useFunctionKey, String.valueOf(proceed), FullConfig.timeOut, FullConfig.timeUnit);
                return JSON.parseArray(proceed);
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
        return JSON.parseArray(value);
    }
}
