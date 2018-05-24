package practice.com.project.message;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class TxMessage {
	@Pointcut("within(practice.com.project.message.MessageServiceImpl)")
	public void pointCut(){}
	@Before("pointCut()")
	public void beginTx(){
		System.out.println("begin transaction");
	}
	@After("pointCut()")
	public void endTx(){
		System.out.println("end transaction");
	}
}
