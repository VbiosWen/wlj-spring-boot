package org.geeksword.springboot.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;

import java.nio.charset.StandardCharsets;

/**
 * @wenliujie
 */
@SpringBootApplication
public class RedisApplication {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    public void main(String args){
        redisTemplate.convertAndSend("test","test");
    }


    public static void main(String[] args){
        SpringApplication.run(RedisApplication.class,args);
    }
}
