package practice.com.project.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TxManagerAspect {
	@Before("within(practice.com.project.service.*)")
	public void beforeAdvice(){
		System.out.println("Tx.beforeAdvice");
	}
	//假如核心业务执行结束，没有出现异常会执行这个后置通知
	@AfterReturning("within(practice.com.project.service.UserServiceImpl)")
	public void returnAdivce(){
		System.out.println("Tx.returnAdivce");
	}
	//当核心业务方法出现异常时会执行此通知，所以经常将此通知理解为异常通知
	//@AfterThrowing("within(practice.com.project.service.UserServiceImpl)")
	@AfterThrowing("bean(userServiceImpl)")
	public void afterThrowing(){
		System.out.println("Tx.afterThrowing");
	}
	//无论核心业务是否正常结束，这个通知都会执行，所以通常将此通知理解为最终通知
	@After("within(practice.com.project.service..*)")
	public void afterAdvice(){
		System.out.println("Tx.afterAdvice");
	}
}
/**
 * try{
 * 	@Before
 * 	核心业务
 *  @AfterReturn
 * }catch(){
 * 	@AfterThrowing
 * }finally{
 * 	@After
 * }
 * 先执行Exception在执行finally
 */
