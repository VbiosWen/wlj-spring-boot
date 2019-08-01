package org.geeksword.springboot.mongo.router;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @wenliujie
 */
@Configuration
@ConfigurationProperties(prefix = "org.geeksword.mongo")
public class MongoConfig {

    private String address;

    private int port;

    private String dbName;

}
