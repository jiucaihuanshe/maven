package practice.com.project.aspect;

import org.springframework.stereotype.Component;
//此类的对象要封装扩展功能（例如日志的处理）
@Component
public class LoggingAspect {
	//希望此方法在核心业务方法执行之前执行
	public void beforeMethod(){
		System.out.println("beforeMethod");
	}
	//希望此方法在核心业务方法执行之后执行
	public void endMethod(){
		System.out.println("endMethod");
	}
}
