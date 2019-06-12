package com.zhyyu.learn.spring.ioc;

import com.zhyyu.learn.spring.jdbc.JdbcTemplateTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 验证Bean1 是否会依赖未完全初始化Bean2(未PostConstruct); 验证Bean3(@PostConstruct) 是否会依赖 未完全初始化 Bean2
 * <pre>
 *     CON:
 *     1. 不会依赖未完全初始化Bean2
 *     2. "new ClassPathXmlApplicationContext("applicationContext.xml");" 会等待初始化完成, 依赖完整对象
 *     3. PostConstruct 方法也不会依赖未完全初始化Bean
 * </pre>
 *
 * @author juror
 * @datatime 2019/6/12 9:39
 */
public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        Bean3 bean3 = (Bean3) applicationContext.getBean("bean3");
        bean3.testPostConstructUseBean2();

        Bean1 bean1 = (Bean1) applicationContext.getBean("bean1");
        bean1.testBean2();
    }

}
