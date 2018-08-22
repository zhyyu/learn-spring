package com.zhyyu.learn.spring.listener;

import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 测试spring event 监听
 * <pre>
 * CON:
 * 1. context 启动 ContextRefreshedEvent 监听到消息, ContextStartedEvent 未监听到
 * 2. 监听 ContextRefreshedEvent 线程与启动spring 线程是同一线程
 * @author zhyyu2016
 *
 */
//@Component
public class ApplicationEventTest {

	@EventListener(ContextRefreshedEvent.class)
	public void onContextRefreshedEvent() {
		String threadName = Thread.currentThread().getName();
		System.out.println("ContextRefreshedEvent, listener thread: " + threadName);
	}
	
	@EventListener(ContextStartedEvent.class)
	public void onContextStartedEvent() {
		String threadName = Thread.currentThread().getName();
		System.out.println("ContextStartedEvent, listener thread: " + threadName);
	}
	
	@EventListener(ContextClosedEvent.class)
	public void onContextClosedEvent() {
		String threadName = Thread.currentThread().getName();
		System.out.println("ContextClosedEvent, listener thread: " + threadName);
	}
	
	@EventListener(ContextStoppedEvent.class)
	public void onContextStoppedEvent() {
		String threadName = Thread.currentThread().getName();
		System.out.println("ContextStoppedEvent, listener thread: " + threadName);
	}

}
