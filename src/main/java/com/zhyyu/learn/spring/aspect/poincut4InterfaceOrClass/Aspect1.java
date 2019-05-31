package com.zhyyu.learn.spring.aspect.poincut4InterfaceOrClass;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aspect1 {

    @Around("@annotation(annotation1)")
    public Object round(ProceedingJoinPoint joinPoint, Annotation1 annotation1) throws Throwable {
        System.out.println("intercept method1");
        return joinPoint.proceed();
    }

}
