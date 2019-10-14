package com.shaoshuai.myblog.config;

import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.apache.ibatis.session.Configuration;
import org.springframework.context.annotation.Bean;

/**
 * @ClassName MybatisConfig
 * @Description TODO
 * @Author Mr. Shao
 * @Date 2019/10/220:17
 * @Version 1.0
 **/
@org.springframework.context.annotation.Configuration
public class MybatisConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return new ConfigurationCustomizer() {
            @Override
            public void customize(Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
