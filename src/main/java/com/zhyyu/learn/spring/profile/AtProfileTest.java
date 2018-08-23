package com.zhyyu.learn.spring.profile;

import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * 测试 @Profile, 仅在 spring.profiles.active 配置对应profile 时构造bean
 * @author zhyyu2016
 *
 */
@Profile({"myProfile", "myProfile1"})
@Component
public class AtProfileTest {

	@EventListener(ContextRefreshedEvent.class)
	public void onContextRefreshedEvent() {
		System.out.println("AtProfileTest bean created");
	}
	
}
