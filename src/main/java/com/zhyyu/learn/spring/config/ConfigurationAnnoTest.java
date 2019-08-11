package com.zhyyu.learn.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 测试 @Configuration 注解
 * <pre>
 *     1. 需要在base-package 下才可生效, 如 applicationContext.xml <context:component-scan base-package="com.zhyyu.learn.spring" />
 *     2. 对应 @Bean 可不写 @Component 相关注解, @PostConstruct 注解依然生效
 * </pre>
 *
 * @author juror
 * @datatime 2019/8/11 19:50
 */
@Configuration
public class ConfigurationAnnoTest {

//    @Bean
    public MyObj buildMyObj() {
        return new MyObj();
    }

}
