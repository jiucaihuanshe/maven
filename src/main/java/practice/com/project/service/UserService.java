package practice.com.project.service;
/**
 * 为没有实现接口的类实现动态代理
 * 测试类：TestCGLIB01
 */
public class UserService {
	public void saveUser(String user){
		System.out.println("save user");
	}
	public void updateUser(String user){
		System.out.println("update user");
	}
	public void deleteUser(String user){
		System.out.println("delete user");
	}
}
