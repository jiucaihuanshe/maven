package practice.com.project.xmlservice;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
/** Spring AOP 核心业务组件定义 */
@Service
public class HelloServiceImpl implements HelloService{

	@Override
	public void sayHello(String msg) {
		System.out.println("hello:"+msg);
	}
	//SpringAOP基于xml方式的实现
	@Test
	public void test(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("xmlapplicationContext.xml");
		HelloService helloService = ctx.getBean("helloServiceImpl", HelloService.class);
		helloService.sayHello("美女");
		ctx.close();
	}
}
