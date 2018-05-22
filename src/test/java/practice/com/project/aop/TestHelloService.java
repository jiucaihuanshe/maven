package practice.com.project.aop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import practice.com.project.service.HelloService;

public class TestHelloService {
	private ClassPathXmlApplicationContext ctx;
	/** ��ʼ��spring���� */
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	/** ���Ծ���ҵ��Ӧ�� */
	@Test
	public void testSayHello(){
		//��ȡ����
		HelloService helloService = ctx.getBean("helloServiceImpl",HelloService.class);
		//ִ��ҵ��
		helloService.sayHello("cang");
		System.out.println(helloService instanceof HelloService);
		/**
		 * ����helloServiceָ���ĸ�����B
		 * A)HelloServiceImpl
		 * B)HelloService	���͵Ĵ������
		 * C)LoggingAspect
		 */
	}
	/** �ͷ���Դ */
	@After
	public void destroy(){
		ctx.close();
	}
}
