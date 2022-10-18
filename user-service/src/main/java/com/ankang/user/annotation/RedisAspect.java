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
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;


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
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        // 拿到类+方法 -> 类-方法
        Signature signature = proceedingJoinPoint.getSignature();
        String useFunctionKey = signature.getDeclaringType().getSimpleName() + "-" + signature.getName();
        //先获取方法和注解  因为只有注解的方法才会进来，所以不需要判空，直接获取
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();
        AutowireRedis annotation = method.getAnnotation(AutowireRedis.class);

        Class targetClass = annotation.targetClass(); // 拿转换目标class
        String operation = annotation.operation(); // 拿操作

        String proceed = "";

        switch (operation) {
            case "select":
                if (Boolean.FALSE.equals(stringRedisTemplate.hasKey(useFunctionKey))) {
                    log.info("redis中没有Key是 -----> [{}]的数据", useFunctionKey);
                    proceed = JSON.toJSONString(proceedingJoinPoint.proceed());
                    stringRedisTemplate.opsForValue().set(useFunctionKey, String.valueOf(proceed), FullConfig.timeOut, FullConfig.timeUnit);
                    return JSON.parseArray(proceed, targetClass);
                }
                break;
            default:
                Boolean changeProceed = (boolean) proceedingJoinPoint.proceed();
                if (changeProceed) {
                    stringRedisTemplate.delete(signature.getDeclaringType().getSimpleName() + "-list");
                }
                return changeProceed;
        }
        return JSON.parseArray(stringRedisTemplate.opsForValue().get(useFunctionKey), targetClass);
    }
}
