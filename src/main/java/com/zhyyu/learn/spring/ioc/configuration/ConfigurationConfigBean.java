package com.zhyyu.learn.spring.ioc.configuration;

import javax.annotation.PostConstruct;

public class ConfigurationConfigBean {

    @PostConstruct
    public void init() {
        System.out.println("ConfigurationConfigBean inited");
    }

    private int i = 0;

    public ConfigurationConfigBean() {
        this.i = 2;
    }

    public int getI() {
        return i;
    }

}
