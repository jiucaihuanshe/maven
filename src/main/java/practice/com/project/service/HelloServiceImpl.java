package practice.com.project.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService{
	//����ҵ��
	@Override
	public void sayHello(String msg) {
		System.out.println("hello:"+msg);
	}
}
