package org.geeksword.springboot.aop.idempotent;


import java.lang.annotation.*;
import java.util.concurrent.TimeUnit;

/**
 * 参数幂等校验.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface IdempotentApi {

    int lockTime() default 0;

    TimeUnit unit() default TimeUnit.SECONDS;

    IdempotentContext strategy() default IdempotentContext.PATH;

}
