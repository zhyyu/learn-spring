package com.zhyyu.learn.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        JdbcTemplateTest jdbcTemplateTest = (JdbcTemplateTest) applicationContext.getBean("jdbcTemplateTest");
        jdbcTemplateTest.queryAll();
    }

}

