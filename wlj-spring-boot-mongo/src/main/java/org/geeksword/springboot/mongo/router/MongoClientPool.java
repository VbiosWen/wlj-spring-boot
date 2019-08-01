package org.geeksword.springboot.mongo.router;

import com.google.common.collect.Maps;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @wenliujie
 */
@Component
public class MongoClientPool implements InitializingBean, DisposableBean {

    @Autowired
    private MongoClientFactory mongoClientFactory;

    public static final ConcurrentHashMap<Object, MongoClient> MONGO_CLIENT_POOL = new ConcurrentHashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void destroy() throws Exception {

    }
}
