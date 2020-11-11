package org.geeksword.mybatis.config;

import com.alibaba.druid.filter.Filter;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

/**
 * @author vbiso
 * @see
 */
@SpringBootConfiguration
public class DruidDataSourceConfiguration {


    @Bean
    @ConfigurationProperties(prefix = "druid")
    public DynamicDruidDataSourceConfig dynamicDruidDataSourceConfig(){
        return new DynamicDruidDataSourceConfig();
    }

    @Bean(initMethod = "init",destroyMethod = "close")
    @ConditionalOnBean(DynamicDruidDataSourceConfig.class)
    @ConfigurationProperties(prefix = "dbcp.master")
    public DynamicDruidDataSourceConfig.DynamicDruidDataSource masterDataSource(List<Filter> filters){
        DynamicDruidDataSourceConfig.DynamicDruidDataSource dynamicDruidDataSource = new DynamicDruidDataSourceConfig.DynamicDruidDataSource();
        dynamicDruidDataSource.setProxyFilters(filters);
        return dynamicDruidDataSource;
    }

    @Bean(initMethod = "init",destroyMethod = "close")
    @ConditionalOnBean(DynamicDruidDataSourceConfig.class)
    @ConfigurationProperties(prefix = "dbcp.slave")
    public DynamicDruidDataSourceConfig.DynamicDruidDataSource slaveDataSource(List<Filter> filters){
        return masterDataSource(filters);
    }

}
