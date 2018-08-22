package com.zhyyu.learn.spring.profile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 测试默认profile, 若未设置, 则为 "default", 且 spring.profiles.default 为null, 若设置  spring.profiles.default, 则为设置值
 * <pre>
 * OUTPUT:
 * spring.profiles.default - null
environment.getDefaultProfiles - default
===================================== manual set spring.profiles.default ================================
spring.profiles.default1 - myDefaultProfile
environment.getDefaultProfiles1 - myDefaultProfile
 * @author zhyyu2016
 *
 */
@Component
public class DefaultProfileTest {
	
	@Autowired
    Environment environment;

	@EventListener(ContextRefreshedEvent.class)
	public void onContextRefreshedEvent() {
		String defaultProfile = System.getProperty("spring.profiles.default");
		System.out.println("spring.profiles.default - " + defaultProfile);
		
		for (String profileName : environment.getDefaultProfiles()) {
            System.out.println("environment.getDefaultProfiles - " + profileName);
        }
		
		System.out.println("===================================== manual set spring.profiles.default ================================");
		System.setProperty("spring.profiles.default", "myDefaultProfile");
		
		String defaultProfile1 = System.getProperty("spring.profiles.default");
		System.out.println("spring.profiles.default1 - " + defaultProfile1);
		
		for (String profileName : environment.getDefaultProfiles()) {
            System.out.println("environment.getDefaultProfiles1 - " + profileName);
        }
	}
	
}
