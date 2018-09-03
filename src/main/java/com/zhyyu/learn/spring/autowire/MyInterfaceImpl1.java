package com.zhyyu.learn.spring.autowire;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class MyInterfaceImpl1 implements MyInterface {

	@Override
	public String myMethod() {
		return "MyInterfaceImpl1";
	}

}
