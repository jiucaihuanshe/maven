package practice.com.project.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
/**
 * ʹ��bean���ʽ���������㣺
 * 1�������ڲ�д����bean������
 * 2�������ڲ�Ҳ����ʹ��ͨ���"*"
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
