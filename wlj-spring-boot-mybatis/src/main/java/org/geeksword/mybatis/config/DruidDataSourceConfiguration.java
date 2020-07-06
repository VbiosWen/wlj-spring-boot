package org.geeksword.mybatis.config;

import com.alibaba.druid.filter.Filter;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * @author vbiso
 * @see
 */
@SpringBootConfiguration
public class DruidDataSourceConfiguration {


    @Bean
    @ConfigurationProperties(prefix = "druid.config")
    public DynamicDruidDataSourceConfig.DynamicDruidDataSource dataSource(List<Filter> filters){
        DynamicDruidDataSourceConfig.DynamicDruidDataSource dynamicDruidDataSource = new DynamicDruidDataSourceConfig.DynamicDruidDataSource();
        dynamicDruidDataSource.setProxyFilters(filters);
        return dynamicDruidDataSource;
    }
}
