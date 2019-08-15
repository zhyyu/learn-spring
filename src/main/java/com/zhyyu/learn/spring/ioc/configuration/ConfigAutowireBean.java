package com.zhyyu.learn.spring.ioc.configuration;

import org.springframework.stereotype.Component;

/**
 * @author juror
 * @datatime 2019/8/15 10:35
 */
@Component
public class ConfigAutowireBean {

    public void hello() {
        System.out.println("ConfigAutowireBean say hello");
    }

}
