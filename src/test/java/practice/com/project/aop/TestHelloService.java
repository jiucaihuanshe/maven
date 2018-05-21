package practice.com.project.aop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import practice.com.project.service.HelloService;

public class TestHelloService {
	private ClassPathXmlApplicationContext ctx;
	/** 初始化spring容器 */
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	/** 测试具体业务应用 */
	@Test
	public void testSayHello(){
		//获取对象
		HelloService helloService = ctx.getBean("helloServiceImpl",HelloService.class);
		//执行业务
		helloService.sayHello("cang");
		System.out.println(helloService instanceof HelloService);
		/**
		 * 请问helloService指向哪个对象？B
		 * A)HelloServiceImpl
		 * B)HelloService	类型的代理对象
		 * C)LoggingAspect
		 */
	}
	/** 释放资源 */
	@After
	public void destroy(){
		ctx.close();
	}
}
