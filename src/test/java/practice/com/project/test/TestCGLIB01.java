package practice.com.project.test;

import java.lang.reflect.Method;
import java.util.logging.Logger;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.InvocationHandler;
import practice.com.project.service.UserService;

public class TestCGLIB01 {
	private static Logger log =Logger.getLogger("TestCGBLIB01");
	public static void main(String[] args) {
		//1.����Ŀ�����
		UserService userService = new UserService();
		//2.�����������
		//2.1������ǿ������
		Enhancer e = new Enhancer();
		//2.2������ǿ�����������
		e.setClassLoader(userService.getClass().getClassLoader());
		//2.3���ô������������(��û��ʵ�ֽӿ�)
		e.setSuperclass(userService.getClass());
		//2.4���ûص�����
		e.setCallback(new InvocationHandler() {
			
			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				log.info("begin tx");
				Object result = method.invoke(userService, args);
				log.info("end tx");
				return result;
			}
		});
		//2.5�����������
		UserService proxy = (UserService) e.create();
		//3.ִ�д������ҵ��
		proxy.saveUser("����");
		proxy.updateUser("tedu");
		proxy.deleteUser("tedu");
	}
}
//JUnit(��Ԫ����)�����ڷ�����Ԫ���в���
