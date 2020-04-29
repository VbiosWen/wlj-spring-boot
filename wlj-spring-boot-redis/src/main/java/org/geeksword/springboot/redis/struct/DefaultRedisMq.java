package org.geeksword.springboot.redis.struct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;

@Component
public class DefaultRedisMq implements RedisMq {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Override
    public void send(String topic, String msg) {
        Long publish = stringRedisTemplate.getConnectionFactory().getConnection().publish(topic.getBytes(StandardCharsets.UTF_8),msg.getBytes(StandardCharsets.UTF_8));
    }

    @Override
    public void send(String topic, Object msg) {

    }
}
