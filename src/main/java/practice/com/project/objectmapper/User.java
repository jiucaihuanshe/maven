package practice.com.project.objectmapper;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	/**
	 * ObjectMapper实体对象
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private int age;
	private String[] list;
	private Date datetime;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String[] getList() {
		return list;
	}
	public void setList(String[] list) {
		this.list = list;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
}
