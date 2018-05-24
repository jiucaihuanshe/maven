package practice.com.project.message;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService{

	@Override
	public void sendMsg(String msg) {
		System.out.println(msg);
	}
	//SpringAOP����ע�ⷽʽ��ʵ��
	@Test
	public void test(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("msgapplicationContext.xml");
		MessageService messageService = ctx.getBean("messageServiceImpl", MessageService.class);
		messageService.sendMsg("��");
		ctx.close();
	}
}
