package org.geeksword.springboot.aop.idempotent;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
@Slf4j
public class IdempotentBuilder {


    @Pointcut("@annotation(idempotentApi)")
    public void pointCut(IdempotentApi idempotentApi) {
    }


    @Around("pointCut(idempotentApi)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, IdempotentApi idempotentApi) throws Throwable {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Assert.notNull(requestAttributes, "request can't be null.");
        HttpServletRequest request = requestAttributes.getRequest();

        IdempotentContext context = idempotentApi.strategy();

        IdempotentStrategy idempotentStrategy = context.strategy();

        String lockKey = idempotentStrategy.getLockKey(request);

        //TODO 获取锁

        //TODO 如果获取锁失败，则直接返回重复提交

        Object object = null;

        try {
            object = proceedingJoinPoint.proceed();
            return object;
        } finally {
           //TODO 释放锁
        }
    }


}
