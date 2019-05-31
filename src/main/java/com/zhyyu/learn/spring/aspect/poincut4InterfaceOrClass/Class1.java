package com.zhyyu.learn.spring.aspect.poincut4InterfaceOrClass;

import org.springframework.stereotype.Component;

/**
 * @author juror
 * @datatime 2019/5/31 11:44
 */
@Component
//public class Class1 implements Interface1 {
public class Class1  {

    @Annotation1
//    @Override
    public void method1() {
        System.out.println("method1 invoked");
    }
}
