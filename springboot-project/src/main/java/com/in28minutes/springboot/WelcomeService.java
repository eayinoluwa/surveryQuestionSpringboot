package com.in28minutes.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//spring to manage this bean and create an instance of this
@Component
public class WelcomeService{
	
	@Value("${welcome.message}")
	private String welcomeMessage;
	
	public String retrieveWelcomeMessage() {
		return welcomeMessage;
	}
}
