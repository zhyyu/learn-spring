package com.zhyyu.learn.spring.ioc;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author juror
 * @datatime 2019/6/12 9:33
 */
@Component
public class Bean2 {

    private Integer i = null;

    @PostConstruct
    private void init() {
        try {
            Thread.sleep(10_000L);
        } catch (InterruptedException e) {
        }

        i = 1024;
    }

    public Integer getI() {
        return i;
    }

}
