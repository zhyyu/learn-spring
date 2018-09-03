package com.zhyyu.learn.spring.autowire;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class MyInterfaceImpl2 implements MyInterface {

	@Override
	public String myMethod() {
		return "MyInterfaceImpl2";
	}

}
