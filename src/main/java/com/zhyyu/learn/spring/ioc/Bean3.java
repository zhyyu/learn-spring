package com.zhyyu.learn.spring.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author juror
 * @datatime 2019/6/12 9:46
 */
@Component
public class Bean3 {

    private Integer i = null;

    @Autowired
    private Bean2 bean2;

    @PostConstruct
    private void init() {
        i = bean2.getI();
    }

    public void testPostConstructUseBean2() {
        System.out.println("testPostConstructUseBean2: " + i);
    }

}
