package org.geeksword.springboot.rocketMQ.model.consumer;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface MQConsumer {

    String topic() default "";
}
