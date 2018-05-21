package practice.com.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import practice.com.project.service.MessageService;


public class TestMessage {
	private static ClassPathXmlApplicationContext ctx;
	public static void init(){
		ctx= new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	public static void close(){
		ctx.close();
	}
	@Test
	public void test(){
		init();
		MessageService messageService = ctx.getBean("messageServiceImpl", MessageService.class);
		messageService.sendMsg("hello");
		close();
	}
}
