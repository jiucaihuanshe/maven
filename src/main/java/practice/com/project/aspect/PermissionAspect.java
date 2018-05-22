package practice.com.project.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
//ִ��Ȩ�޼�������
@Aspect
@Component
public class PermissionAspect {
	@Before("execution(* practice.com.project..*.*(String,..))")
	public void checkPermission(JoinPoint joinPoint){//JoinPoint joinPoint ��ʾһ�����ӵ�,������ӵ��Ӧ����Ҫִ�е��Ǹ�����ҵ�񷽷�����
		System.out.println("Ȩ�޼��");
		//��ȡ���ӵ��Ӧ�ķ���ǩ����Ϣ����Ӧ���ķ�����Ϣ��
		Signature s = joinPoint.getSignature();
		String methodName= s.getName();
		System.out.println("methodName="+methodName);
		//��ȡʵ�ʲ�����Ӧ��ֵ
		Object[] args = joinPoint.getArgs();
		for(Object a:args){
			System.out.println("a="+a);
			System.out.println("a.class="+a.getClass());
		}
		//���ݷ������Ͳ������ͻ�ȡ��Ӧ�ķ�������
		//1.��÷�����Ӧ��Ŀ�����������
		Class<?> targsCls = joinPoint.getTarget().getClass();
		System.out.println("targsCls="+targsCls);
		//2.��ȡ��������Method��
		//targsCls.getDeclaredMethod(name, parameterTypes)
	}
}
