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
	//�������ҵ��ִ�н�����û�г����쳣��ִ���������֪ͨ
	@AfterReturning("within(practice.com.project.service.UserServiceImpl)")
	public void returnAdivce(){
		System.out.println("Tx.returnAdivce");
	}
	//������ҵ�񷽷������쳣ʱ��ִ�д�֪ͨ�����Ծ�������֪ͨ���Ϊ�쳣֪ͨ
	//@AfterThrowing("within(practice.com.project.service.UserServiceImpl)")
	@AfterThrowing("bean(userServiceImpl)")
	public void afterThrowing(){
		System.out.println("Tx.afterThrowing");
	}
	//���ۺ���ҵ���Ƿ��������������֪ͨ����ִ�У�����ͨ������֪ͨ���Ϊ����֪ͨ
	@After("within(practice.com.project.service..*)")
	public void afterAdvice(){
		System.out.println("Tx.afterAdvice");
	}
}
/**
 * try{
 * 	@Before
 * 	����ҵ��
 *  @AfterReturn
 * }catch(){
 * 	@AfterThrowing
 * }finally{
 * 	@After
 * }
 * ��ִ��@After��ִ��@AfterReturn
 * ��ִ��@After��ִ��@AfterThrowing
 */
