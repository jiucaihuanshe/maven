package practice.com.project.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
/**
 * 使用bean表达式定义的切入点：
 * 1）括号内部写的是bean的名字
 * 2）括号内部也可以使用通配符"*"
 */
@Aspect
@Component
public class LoggingAspect01 {
	@Before("bean(*ServiceImpl)")
	public void beforeAdvice(){
		System.out.println("log.beforeAdvice");
	}
	@After("bean(userServiceImpl)")
	public void afterAdvice(){
		System.out.println("log.afterAdvice");
	}
}
