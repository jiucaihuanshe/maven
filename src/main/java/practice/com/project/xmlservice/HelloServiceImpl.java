package practice.com.project.xmlservice;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
/** Spring AOP ����ҵ��������� */
@Service
public class HelloServiceImpl implements HelloService{

	@Override
	public void sayHello(String msg) {
		System.out.println("hello:"+msg);
	}
	//SpringAOP����xml��ʽ��ʵ��
	@Test
	public void test(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("xmlapplicationContext.xml");
		HelloService helloService = ctx.getBean("helloServiceImpl", HelloService.class);
		helloService.sayHello("��Ů");
		ctx.close();
	}
}
