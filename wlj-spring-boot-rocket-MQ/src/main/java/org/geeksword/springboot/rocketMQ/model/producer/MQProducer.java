package org.geeksword.springboot.rocketMQ.model.producer;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface MQProducer {

    String topic() default "";

    boolean delay() default false;

    long delayTime() default 0L;

    boolean sync() default true;

}
