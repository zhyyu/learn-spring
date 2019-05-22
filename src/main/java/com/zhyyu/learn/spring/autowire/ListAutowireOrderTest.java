package com.zhyyu.learn.spring.autowire;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class ListAutowireOrderTest {

	@Autowired
	private List<MyInterface> myInterfaceList;
	
	@PostConstruct
	public void postConstruct() {
		for (MyInterface myInterface : myInterfaceList) {
			System.out.println(myInterface.myMethod());
		}
	}
	
}
