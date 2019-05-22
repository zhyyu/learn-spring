package com.zhyyu.learn.spring.aspect;

import org.springframework.stereotype.Component;

/**
 * @author juror
 * @datatime 2019/5/22 15:22
 */
@Component
public class TargetObject {

    public void method1() {
        System.out.println("method invoked");
    }

}
