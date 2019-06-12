package com.zhyyu.learn.spring.ioc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author juror
 * @datatime 2019/6/12 9:33
 */
@Component
public class Bean1 {

    @Autowired
    private Bean2 bean2;

    public void testBean2() {
        while (true) {
            System.out.println("bean2 i: " + bean2.getI());
            try {
                Thread.sleep(500L);
            } catch (InterruptedException e) {
            }
        }
    }

}
