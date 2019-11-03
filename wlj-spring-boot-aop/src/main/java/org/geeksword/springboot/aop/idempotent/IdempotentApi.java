package org.geeksword.springboot.aop.idempotent;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

/**
 * 参数幂等校验.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface IdempotentApi {

    int lockTime() default 0;

    TimeUnit unit() default TimeUnit.SECONDS;
}
