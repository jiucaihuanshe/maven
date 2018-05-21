package practice.com.project.aop;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import practice.com.project.service.UserService01;


/**
 * 测试切入点表达式增强(bean)
 * @author Administrator
 *
 */
public class TestUserService {
	private ClassPathXmlApplicationContext ctx;
	@Before
	public void init(){
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	@Test
	public void testSaveUser(){
		UserService01 userService01 = ctx.getBean("userServiceImpl",UserService01.class);
		userService01.saveUser("薯片");
	}
	@Test
	public void testUpdateUser(){
		UserService01 userService01 = ctx.getBean("userServiceImpl",UserService01.class);
		userService01.updateUser("鼠标");
	}
	@Test
	public void testfindUserById(){
		UserService01 userService01 = ctx.getBean("userServiceImpl",UserService01.class);
		userService01.findUserById(24);
	}
	@After
	public void destroy(){
		ctx.close();
	}
}
