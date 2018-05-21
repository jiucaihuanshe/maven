package practice.com.project.service;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/** 扩展业务
 *  其中：
 *  @Component 表示此组件由spring对象管理
 *  @Aspect	用于定义切面（封装扩展功能）
 *  @Pointcut 用于定义切入点（用于植入扩展功能的点）
 *  @Before 用于定义前置通知（业务处理之前执行）
 *  @After 用于定义最终通知（业务方法执行完成以后执行）
 */
@Component
@Aspect
public class TxMessage {
	/**定义切入点（可以简化对表达式的引用，可以在通知上直接
	 * 使用@Pointcut注解修饰的方法签名）
	 */
	@Pointcut("within(practice.com.project.service.MessageServiceImpl)")
	public void pointCut(){}
	//在切入点表达式对应的业务类的方法执行之前执行
	@Before("pointCut()")
	public void beginTx(){
		System.out.println("begin transaction");
	}
	//在切入点表达式对应的业务类的方法执行之后执行
	@After("pointCut()")
	public void endTx(){
		System.out.println("end transaction");
	}
}
