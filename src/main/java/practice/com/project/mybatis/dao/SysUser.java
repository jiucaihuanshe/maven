package practice.com.project.mybatis.dao;

import java.io.Serializable;
import java.util.Date;
/**
 * ʵ����󣺷�װ���ݣ�ʵ����������ݵ�ӳ��
 * 1.��Ϊ���л��ͷ����л���
 * 2.���л�����汾id��ʲô���ã�
 * 3.�������л������Ƿ���Զ����ݽ��м��ܣ�
 * 4.��ζԶ������л�����ϸ�ܶȿ��ƣ�transient
 */
public class SysUser implements Serializable{
	private static final long serialVersionUID = 2332312567578114619L;
	private Integer id;
	private String username;
	private String password;
	private String phone;
	private Date createdDate;
	private Date modifiedDate;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	@Override
	public String toString() {
		return "SysUser [id=" + id + ", username=" + username + ", password=" + password + ", phone=" + phone
				+ ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + "]";
	}
	
}
