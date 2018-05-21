package practice.com.project.test;

import java.lang.reflect.Method;
import java.util.logging.Logger;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;
import practice.com.project.service.UserService;

public class TestCGLIB01 {
	private static Logger log =Logger.getLogger("TestCGBLIB01");
	public static void main(String[] args) {
		//1.创建目标对象
		UserService userService = new UserService();
		//2.创建代理对象
		//2.1创建增强器对象
		Enhancer e = new Enhancer();
		//2.2设置增强器的类加载器
		e.setClassLoader(userService.getClass().getClassLoader());
		//2.3设置代理对象父类类型(类没有实现接口)
		e.setSuperclass(userService.getClass());
		//2.4设置回调函数
		e.setCallback(new InvocationHandler() {
			
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				log.info("begin tx");
				Object result = method.invoke(userService, args);
				log.info("end tx");
				return result;
			}
		});
		//2.5创建代理对象
		UserService proxy = (UserService) e.create();
		//3.执行代理对象业务
		proxy.saveUser("尔康");
		proxy.updateUser("tedu");
		proxy.deleteUser("tedu");
	}
}
//JUnit(单元测试)：基于方法单元进行测试
