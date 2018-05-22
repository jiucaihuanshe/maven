package practice.com.project.service;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/** ��չҵ��
 *  ���У�
 *  @Component ��ʾ�������spring�������
 *  @Aspect	���ڶ������棨��װ��չ���ܣ�
 *  @Pointcut ���ڶ�������㣨����ֲ����չ���ܵĵ㣩
 *  @Before ���ڶ���ǰ��֪ͨ��ҵ����֮ǰִ�У�
 *  @After ���ڶ�������֪ͨ��ҵ�񷽷�ִ������Ժ�ִ�У�
 */
@Component
@Aspect
public class TxMessage {
	/**��������㣨���Լ򻯶Ա��ʽ�����ã�������֪ͨ��ֱ��
	 * ʹ��@Pointcutע�����εķ���ǩ����
	 */
	@Pointcut("within(practice.com.project.service.MessageServiceImpl)")
	public void pointCut(){}
	//���������ʽ��Ӧ��ҵ����ķ���ִ��֮ǰִ��
	@Before("pointCut()")
	public void beginTx(){
		System.out.println("begin transaction");
	}
	//���������ʽ��Ӧ��ҵ����ķ���ִ��֮��ִ��
	@After("pointCut()")
	public void endTx(){
		System.out.println("end transaction");
	}
}
