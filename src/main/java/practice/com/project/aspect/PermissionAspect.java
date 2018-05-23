package practice.com.project.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import practice.com.project.service.Permission;
//执行权限检测的切面
@Aspect
@Component
public class PermissionAspect {
	@Before("execution(* practice.com.project..*.*(String,..))")
	public void checkPermission(JoinPoint joinPoint){//JoinPoint joinPoint 表示一个连接点,这个连接点对应的是要执行的那个核心业务方法对象
		System.out.println("权限检测");
		//获取连接点对应的方法签名信息（对应核心方法信息）
		Signature s = joinPoint.getSignature();
		String methodName= s.getName();
		System.out.println("methodName="+methodName);
		//获取实际参数对应的值
		Object[] args = joinPoint.getArgs();
		//构建一个数组对象，封装参数类型信息
		Class<?>[] parameterTypes = new Class<?>[args.length];
		for(int i=0;i<args.length;i++){
			System.out.println("a="+args[i]);//获取实际参数的对应的值
			System.out.println("a.class="+args[i].getClass());//获取实际参数对应的参数类型
			parameterTypes[i]=args[i].getClass();
		}
		//根据方法名和参数类型获取对应的方法对象
		//1.获得方法对应的目标对象的类对象
		Class<?> targsCls = joinPoint.getTarget().getClass();
		
		System.out.println("targsCls="+targsCls);
		//2.获取方法对象（Method）
		//2.获取方法对象（Method）唯一确定一个方法的就是它的方法名和参数列表
		Method m=null;
		try {
			m = targsCls.getDeclaredMethod(methodName, parameterTypes);
			System.out.println(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//3.获取方法对象上的注解
		//判定方法上是否有使用了Permission注解
		if(m.isAnnotationPresent(Permission.class)){
			System.out.println("执行"+methodName+"此方法需要权限检测");
		}else{
			System.out.println("执行"+methodName+"此方法不需要权限检测");
		}
	}
}
