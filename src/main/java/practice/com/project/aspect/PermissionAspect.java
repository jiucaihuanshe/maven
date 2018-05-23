package practice.com.project.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import practice.com.project.service.Permission;
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
		//����һ��������󣬷�װ����������Ϣ
		Class<?>[] parameterTypes = new Class<?>[args.length];
		for(int i=0;i<args.length;i++){
			System.out.println("a="+args[i]);//��ȡʵ�ʲ����Ķ�Ӧ��ֵ
			System.out.println("a.class="+args[i].getClass());//��ȡʵ�ʲ�����Ӧ�Ĳ�������
			parameterTypes[i]=args[i].getClass();
		}
		//���ݷ������Ͳ������ͻ�ȡ��Ӧ�ķ�������
		//1.��÷�����Ӧ��Ŀ�����������
		Class<?> targsCls = joinPoint.getTarget().getClass();
		
		System.out.println("targsCls="+targsCls);
		//2.��ȡ��������Method��
		//2.��ȡ��������Method��Ψһȷ��һ�������ľ������ķ������Ͳ����б�
		Method m=null;
		try {
			m = targsCls.getDeclaredMethod(methodName, parameterTypes);
			System.out.println(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
		//3.��ȡ���������ϵ�ע��
		//�ж��������Ƿ���ʹ����Permissionע��
		if(m.isAnnotationPresent(Permission.class)){
			System.out.println("ִ��"+methodName+"�˷�����ҪȨ�޼��");
		}else{
			System.out.println("ִ��"+methodName+"�˷�������ҪȨ�޼��");
		}
	}
}
