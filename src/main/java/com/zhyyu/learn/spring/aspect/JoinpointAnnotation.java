package com.zhyyu.learn.spring.aspect;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author juror
 * @datatime 2019/5/22 15:53
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface JoinpointAnnotation {

    String attr1() default "";

    String attr2() default "";

}
