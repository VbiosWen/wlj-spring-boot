package org.geeksword.springboot.util.configuration;

import lombok.Setter;
import org.geeksword.springboot.util.lru.LinkedHashMapLRUCache;
import org.geeksword.springboot.util.registar.DateTimeEditorRegistrar;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

/**
 * @wenliujie
 */
@Configuration
@ConfigurationProperties(prefix = "spring.text.to.date")
@Setter
public class UtilConfiguration {

    private String format = "yyyy-MM-dd HH:mm:ss";

    @Bean
    public DateTimeEditorRegistrar dateTimeEditorRegistrar(){
        return new DateTimeEditorRegistrar(format);
    }


    @Bean("testLRUCache")
    public LinkedHashMapLRUCache<String,Object> linkedHashMapLRUCache(){
        return new LinkedHashMapLRUCache<>(1024);
    }
}
