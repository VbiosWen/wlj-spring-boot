package org.geeksword.springboot.util;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @wenliujie
 */
@SpringBootApplication
public class UtilApplication {

    public static void main(String[] args){
        ConfigurableApplicationContext run = SpringApplication.run(UtilApplication.class, args);

    }
}
