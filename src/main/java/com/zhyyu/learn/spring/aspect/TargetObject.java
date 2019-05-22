package com.zhyyu.learn.spring.aspect;

import org.springframework.stereotype.Component;

/**
 * @author juror
 * @datatime 2019/5/22 15:22
 */
@Component
public class TargetObject {

    @JoinpointAnnotation(attr1 = "attr1111", attr2 = "attr2222")
    public void method1(String args1, @ArgAnnotation String args2) {
        System.out.println("args1: " + args1);
        System.out.println("args2: " + args2);
        System.out.println("method invoked");
    }

}
