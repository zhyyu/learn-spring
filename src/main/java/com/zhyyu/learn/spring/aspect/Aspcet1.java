package com.zhyyu.learn.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author juror
 * @datatime 2019/5/22 15:08
 */
@Aspect
@Order(1)
@Component
public class Aspcet1 {

    @Around("execution(void com.zhyyu.learn.spring.aspect.TargetObject.method1(..))")
    private Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Aspect1 begin");
        Object result = joinPoint.proceed();
        System.out.println("Aspect1 end");
        return result;
    }

}
