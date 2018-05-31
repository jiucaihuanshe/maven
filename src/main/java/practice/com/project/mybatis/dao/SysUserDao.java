package practice.com.project.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import practice.com.project.mybatis.vo.Account;

public interface SysUserDao {
	List<Map<String, Object>> findUsers();
	Map<String, Object> findUserById(Integer id);
	int insertObject(SysUser entity);
	int updateObject(SysUser entity);
	int deleteObject(SysUser entity);
	
	//����resultMap
	List<Account> findNameAndPwd();
	//����id������
	int insertObject1(SysUser entity);
	//���Ի�ı���ַ���
	//����ʹ��$ȡ������ֵ����ʱҪʹ��@Paramע��Բ�����������
	//��ʹ��#��ȡ������ֵʱ������ӿڷ������ж��������ʹ��@Paramע���������
	List<Map<String, Object>> findUsers1(@Param("columnName") String columnName,@Param("phone") String phone);
	
	List<SysUser> findUsersByPhone(@Param("phone") String phone);
	
	List<SysUser> findUsersByIf(@Param("id") Integer id,@Param("username") String username,@Param("phone") String phone);
	
	int deleteForeach(@Param("ids") String[] ids);
}
