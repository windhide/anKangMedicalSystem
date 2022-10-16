package com.ankang.annotation;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.aspectj.lang.ProceedingJoinPoint;
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

    /**
     * 切入点,基于注解实现的切入点  加上该注解的都是Aop切面的切入点
     * 匹配top.alanlee.template.controller包及其子包下的所有类的所有方法
     */
    @Pointcut("@annotation(com.ankang.annotation.AutowireRedis)")
    public void pointCut() {
    }

    /**
     * 环绕通知
     * 环绕通知非常强大，可以决定目标方法是否执行，什么时候执行，执行时是否需要替换方法参数，执行完毕是否需要替换返回值。
     * 环绕通知第一个参数必须是org.aspectj.lang.ProceedingJoinPoint类型
     *
     * @param proceedingJoinPoint
     */
    @Around("pointCut()")
    public Object aroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
        log.info("----------- 环绕通知 -----------");
        return null;
    }

}
