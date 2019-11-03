package org.geeksword.springboot.aop.idempotent;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
@Slf4j
public class IdempotentBuilder {

    @Pointcut("@annotation(idempotentApi)")
    public void pointCut(IdempotentApi idempotentApi) {
    }


    @Around("pointCut(idempotentApi)")
    public Object around(ProceedingJoinPoint proceedingJoinPoint, IdempotentApi idempotentApi) {
        int lockTime = idempotentApi.lockTime();
        TimeUnit unit = idempotentApi.unit();

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        Assert.notNull(requestAttributes, "request can't be null.");
        HttpServletRequest request = requestAttributes.getRequest();

        String token = request.getHeader("token");
        String servletPath = request.getServletPath();
        Map<String, String[]> parameterMap = request.getParameterMap();

        MessageDigest md5 = MessageDigest.getInstance("MD5");

    }


}
