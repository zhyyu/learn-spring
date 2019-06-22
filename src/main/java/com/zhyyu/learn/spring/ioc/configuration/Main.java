package com.zhyyu.learn.spring.ioc.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  测试 @Configuration
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        ConfigurationConfigBean configurationConfigBean = (ConfigurationConfigBean) applicationContext.getBean("configurationConfigBean");
        System.out.println(configurationConfigBean.getI());
    }

}
