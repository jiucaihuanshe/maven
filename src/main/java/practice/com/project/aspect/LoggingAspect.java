package practice.com.project.aspect;

import org.springframework.stereotype.Component;
//����Ķ���Ҫ��װ��չ���ܣ�������־�Ĵ���
@Component
public class LoggingAspect {
	//ϣ���˷����ں���ҵ�񷽷�ִ��֮ǰִ��
	public void beforeMethod(){
		System.out.println("beforeMethod");
	}
	//ϣ���˷����ں���ҵ�񷽷�ִ��֮��ִ��
	public void endMethod(){
		System.out.println("endMethod");
	}
}
