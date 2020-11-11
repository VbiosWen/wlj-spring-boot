package org.geeksword.springboot.redis.lua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisLuaManager {

    @Autowired
    private RedisTemplate redisTemplate;

    public void test(){
      //  redisTemplate.getConnectionFactory().getConnection().eval(null);
    }

}
