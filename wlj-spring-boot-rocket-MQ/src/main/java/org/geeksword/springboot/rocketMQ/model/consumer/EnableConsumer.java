package org.geeksword.springboot.rocketMQ.model.consumer;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(ConsumerScanRegistrar.class)
public @interface EnableConsumer {

    String[] basePackages() default {};


}
