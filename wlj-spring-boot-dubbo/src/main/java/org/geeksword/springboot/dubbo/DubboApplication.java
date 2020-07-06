package org.geeksword.springboot.dubbo;

import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.geeksword.springboot.dubbo.api.TestService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

/**
 * @wenliujie
 */
@SpringBootApplication
@EnableDubbo
public class DubboApplication {

    @Reference
    private TestService testService;

    public static void main(String[] args) {
        SpringApplication.run(DubboApplication.class, args);
    }
}
