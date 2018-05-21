package practice.com.project.service;

import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

	public void sendMsg(String msg) {
		System.out.println(msg);
	}
}
