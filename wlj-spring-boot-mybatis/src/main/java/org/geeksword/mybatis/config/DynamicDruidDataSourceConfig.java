package org.geeksword.mybatis.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.SpringBootConfiguration;

import java.util.Map;
import java.util.Set;

/**
 * @author vbiso
 * @see
 */
@SpringBootConfiguration
public class DynamicDruidDataSourceConfig {

    private Map<String, DynamicDruidDataSource> druidDataSourceConfigMap;



    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class DynamicDruidDataSource extends DruidDataSource {
        /**
         * 是否是写库
         */
        private Boolean master;

        /**
         * 路由到当前库的表
         */
        private Set<String> table;
    }
}
