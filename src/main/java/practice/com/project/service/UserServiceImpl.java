package practice.com.project.service;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService01{

	@Override
	public void saveUser(String user) {
		System.out.println("save:"+user);
		throw new RuntimeException("save.exception");
	}

	@Override
	public void updateUser(String user) {
		System.out.println("update:"+user);
	}

	@Override
	public Object findUserById(Integer id) {
		System.out.println("findUserById:"+id);
		return "–‹√®";
	}

}
