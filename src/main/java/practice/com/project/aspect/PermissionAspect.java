package practice.com.project.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
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
		for(Object a:args){
			System.out.println("a="+a);
			System.out.println("a.class="+a.getClass());
		}
		//根据方法名和参数类型获取对应的方法对象
		//1.获得方法对应的目标对象的类对象
		Class<?> targsCls = joinPoint.getTarget().getClass();
		System.out.println("targsCls="+targsCls);
		//2.获取方法对象（Method）
		//targsCls.getDeclaredMethod(name, parameterTypes)
	}
}
