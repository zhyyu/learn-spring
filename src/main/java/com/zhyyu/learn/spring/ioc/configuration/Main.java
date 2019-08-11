package com.zhyyu.learn.spring.ioc.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *  测试 @Configuration
 *
 *   * <pre>
 *  *     1. 需要在base-package 下才可生效, 如 applicationContext.xml <context:component-scan base-package="com.zhyyu.learn.spring" />
 *  *     2. 对应 @Bean 可不写 @Component 相关注解, @PostConstruct 注解依然生效
 *  * </pre>
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        ConfigurationConfigBean configurationConfigBean = (ConfigurationConfigBean) applicationContext.getBean("configurationConfigBean");
        System.out.println(configurationConfigBean.getI());
    }

}
