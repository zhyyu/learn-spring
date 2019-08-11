package com.zhyyu.learn.spring.config;

import javax.annotation.PostConstruct;

/**
 * @author juror
 * @datatime 2019/8/11 19:50
 */
public class MyObj {

    @PostConstruct
    public void init() {
        System.out.println("myObj inited");
    }

}
