package org.geeksword.springboot.aop.log;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.time.Instant;

/**
 * @wenliujie
 */
@Aspect
@Component
public class LogAop {

    @Pointcut("@annotation(LogBuilder)")
    public void pointCut(){

    }

    @Before(value = "pointCut()")
    public void before(JoinPoint joinPoint){

    }

    @AfterReturning(value = "pointCut()")
    public void afterReturning(JoinPoint joinPoint){

    }

    @AfterThrowing(value = "pointCut()")
    public void afterThrowing(JoinPoint joinPoint){
        joinPoint.getTarget();
    }

    @Around(value = "pointCut()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint){
        long start = Instant.now().toEpochMilli();
        Object result;
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            //TODO log error info
            throw new RuntimeException(throwable);
        }finally {
            long end = Instant.now().toEpochMilli();
            long costTimes = end - start;
            //TODO log
        }
        return result;
    }
}
