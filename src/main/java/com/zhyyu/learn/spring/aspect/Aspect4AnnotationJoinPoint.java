package com.zhyyu.learn.spring.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 参考
 * <br>
 * https://progressive-code.com/post/6/Spring-AOP-in-conjunction-with-custom-annotations
 * <br>
 * https://docs.spring.io/spring/docs/4.3.15.RELEASE/spring-framework-reference/html/aop.html#aop-ataspectj
 * https://stackoverflow.com/questions/52928140/multiple-around-advices-with-argument-binding-on-a-single-join-point-causes-erro
 *
 * <pre>
 *     注意, @Order 不能使用Ordered.HIGHEST_PRECEDENCE, 否则 "Required to bind 2 arguments, but only bound 1 " 异常, 替换为其他, 如3 ok, 原因待定
 * </pre>
 *
 * @author juror
 * @datatime 2019/5/22 15:58
 *
 */
@Aspect
//@Order(Ordered.HIGHEST_PRECEDENCE)
@Order(3)
@Component
public class Aspect4AnnotationJoinPoint {

//    @Around("@annotation(com.zhyyu.learn.spring.aspect.JoinpointAnnotation)")

    // 若要和获取绑定annotation 信息, expression 需要写名称
    @Around("@annotation(joinpointAnnotation)")
//    @Around("execution(void com.zhyyu.learn.spring.aspect.TargetObject.method1(..))")
    public Object round(ProceedingJoinPoint joinPoint, JoinpointAnnotation joinpointAnnotation) throws Throwable {
//    public Object round(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Aspect4AnnotationJoinPoint, joinpointAnnotation: " + joinpointAnnotation);

        Object[] args = joinPoint.getArgs();
        System.out.println("Aspect4AnnotationJoinPoint, args: " + Arrays.asList(args));

        Signature signature = joinPoint.getSignature();
        System.out.println("Aspect4AnnotationJoinPoint, signature: " + signature);

        System.out.println("Aspect4AnnotationJoinPoint, getName: " + signature.getName());
        System.out.println("Aspect4AnnotationJoinPoint, getDeclaringType: " + signature.getDeclaringType());
        System.out.println("Aspect4AnnotationJoinPoint, getDeclaringTypeName: " + signature.getDeclaringTypeName());
        System.out.println("Aspect4AnnotationJoinPoint, getModifiers: " + signature.getModifiers());

        List<? extends Class<?>> argClassList = Arrays.asList(args).stream().map(Object::getClass).collect(Collectors.toList());
        Class[] argClassArr = new Class[argClassList.size()];
        argClassArr = argClassList.toArray(argClassArr);

        // 通过 MethodSignature 亦可获取参数类型数组
//        MethodSignature methodSig = (MethodSignature) joinPoint.getSignature();
//        Class[] argClassArr = methodSig.getParameterTypes();

        Method method = signature.getDeclaringType().getMethod(signature.getName(), argClassArr);
        System.out.println("Aspect4AnnotationJoinPoint, method: " + method);

        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (int i = 0; i < parameterAnnotations.length; i++) {
            Annotation[] parameterAnnotation = parameterAnnotations[i];
            for (Annotation annotation : parameterAnnotation) {
                if (annotation instanceof ArgAnnotation) {
                    System.out.println("Aspect4AnnotationJoinPoint, annotation arg: " + args[i]);
                }
            }
        }
        
        return joinPoint.proceed();
    }

}
