package practice.com.project.service;

import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService{
	//ºËÐÄÒµÎñ
	@Override
	public void sayHello(String msg) {
		System.out.println("hello:"+msg);
	}
}
