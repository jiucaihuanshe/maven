package practice.com.project.xmlservice;

import org.springframework.stereotype.Component;

@Component
public class LoggingAspect {
	public void beforeMethod(){
		System.out.println("beforeMethod");
	}
	public void afterMethod(){
		System.out.println("afterMethod");
	}
}
