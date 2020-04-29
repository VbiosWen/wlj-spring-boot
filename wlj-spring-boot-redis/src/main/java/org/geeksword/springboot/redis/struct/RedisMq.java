package org.geeksword.springboot.redis.struct;

public interface RedisMq {

    void send(String topic,String msg);

    void send(String topic, Object msg);

}
