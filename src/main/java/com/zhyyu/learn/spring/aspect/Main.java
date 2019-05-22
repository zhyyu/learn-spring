package com.zhyyu.learn.spring.aspect;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author juror
 * @datatime 2019/5/22 15:36
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        TargetObject targetObject = (TargetObject) applicationContext.getBean("targetObject");
        targetObject.method1();
    }

}

/*
    Aspect1 begin
    Aspect2 begin
    method invoked
    Aspect2 end
    Aspect1 end

    优先级高, 先执行, 如aspect1, 在更外外围
*/
