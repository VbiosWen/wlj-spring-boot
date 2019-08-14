package org.geeksword.springboot.util;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @wenliujie
 */
@SpringBootApplication
public class UtilApplication implements DisposableBean {

    public static void main(String[] args){
        ConfigurableApplicationContext run = SpringApplication.run(UtilApplication.class, args);
        ConcurrentHashMap<String,Object> stringObjectConcurrentHashMap = new ConcurrentHashMap<>();

        stringObjectConcurrentHashMap.put("teswt","test");

    }

    @Override
    public void destroy() throws Exception {

    }
}
