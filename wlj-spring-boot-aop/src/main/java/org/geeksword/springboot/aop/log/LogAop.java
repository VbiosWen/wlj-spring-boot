package org.geeksword.springboot.aop.log;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Parameter;
import java.time.Instant;
import java.util.Arrays;

/**
 * @wenliujie
 */
@Aspect
@Component
@Slf4j
public class LogAop {

    @Pointcut("@annotation(LogBuilder)")
    public void pointCut() {
    }

    @Around(value = "pointCut()",argNames = "proceedingJoinPoint")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) {
        long start = Instant.now().toEpochMilli();
        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        String name = signature.getMethod().getName();
        Parameter[] parameters = signature.getMethod().getParameters();
        Object result;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            log.error("api use error :", throwable);
            throw new RuntimeException(throwable);
        } finally {
            long end = Instant.now().toEpochMilli();
            long costTimes = end - start;
            //TODO log
            log.info("{} method,parameters{} execute cost times :{}", name, Arrays.stream(parameters).map(Parameter::getName).toArray(), costTimes);
        }
        return result;
    }
}
