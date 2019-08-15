package com.zhyyu.learn.spring.ioc.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationTest {

    @Autowired
    private ConfigAutowireBean configAutowireBean;

    @Bean
    public ConfigurationConfigBean configurationConfigBean() {
        configAutowireBean.hello();
        return new ConfigurationConfigBean();
    }

}
