package org.geeksword.springboot.util;

import org.geeksword.springboot.util.event.StandardPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author vbiso
 * @see
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Application.class, args);
        StandardPublisher bean = run.getBean(StandardPublisher.class);
        bean.publish("test");
    }
}
