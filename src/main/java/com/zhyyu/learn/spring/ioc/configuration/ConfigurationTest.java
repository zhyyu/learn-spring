package com.zhyyu.learn.spring.ioc.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationTest {

    @Bean
    public ConfigurationConfigBean configurationConfigBean() {
        return new ConfigurationConfigBean();
    }

}
