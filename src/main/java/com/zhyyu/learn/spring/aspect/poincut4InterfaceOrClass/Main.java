package com.zhyyu.learn.spring.aspect.poincut4InterfaceOrClass;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 验证接口方法注解, 类方法注解; 默认代理方法, 有无实现接口
 * <pre>
 *     1. 接口加注解, 类不加注解, aop 不生效
 *     2. 接口不加注解, 类加注解, aop 生效
 *     3. 默认(实现接口) class com.sun.proxy.$Proxy10 代理对象, jkd 动态代理
 *     4. 默认(无实现接口) com.zhyyu.learn.spring.aspect.poincut4InterfaceOrClass.Class1$$EnhancerBySpringCGLIB$$5440b087, cglib 代理
 * </pre>
 * @author juror
 * @datatime 2019/5/22 15:36
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        /*Interface1 interface1 = (Interface1) applicationContext.getBean("class1");
        System.out.println(interface1);
        System.out.println(interface1.getClass());
        interface1.method1();*/

        Class1 class1 = (Class1) applicationContext.getBean("class1");
        System.out.println(class1);
        System.out.println(class1.getClass());
        class1.method1();
    }

}

/**
 * 接口加注解, 类不加注解, aop 不生效
 * output:
 * com.zhyyu.learn.spring.aspect.poincut4InterfaceOrClass.Class1@3cc1435c
 * class com.zhyyu.learn.spring.aspect.poincut4InterfaceOrClass.Class1
 * method1 invoked
 *
 * com.zhyyu.learn.spring.aspect.poincut4InterfaceOrClass.Class1 对象未被代理
 *
 * 接口不加注解, 类加注解, aop 生效
 * output:
 * com.zhyyu.learn.spring.aspect.poincut4InterfaceOrClass.Class1@41c2284a
 * class com.sun.proxy.$Proxy10
 * intercept method1
 * method1 invoked
 *
 * class com.sun.proxy.$Proxy10 代理对象, jkd 动态代理
 *
 * 类不继承接口, 类加注解, aop 生效
 * output:
 * com.zhyyu.learn.spring.aspect.poincut4InterfaceOrClass.Class1@776b83cc
 * class com.zhyyu.learn.spring.aspect.poincut4InterfaceOrClass.Class1$$EnhancerBySpringCGLIB$$5440b087
 * intercept method1
 * method1 invoked
 *
 * class com.zhyyu.learn.spring.aspect.poincut4InterfaceOrClass.Class1$$EnhancerBySpringCGLIB$$5440b087, cglib 动态代理
 */
