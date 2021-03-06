package com.zhyyu.learn.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring 应用启动器, -Dspring.profiles.active=myProfile
 * @author zhyyu2016
 *
 */
public class ApplicationStarter {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		String threadName = Thread.currentThread().getName();
		System.out.println("start appliation context, thread: " + threadName);
		
		while (true);
	}
	
}
