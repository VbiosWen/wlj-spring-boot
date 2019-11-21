package org.geeksword.springboot.rocketMQ.model.producer;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface EnableProducer {


    String[] basePackages() default {};
}
