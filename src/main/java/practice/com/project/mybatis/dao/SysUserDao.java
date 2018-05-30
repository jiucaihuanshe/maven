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
	
	//测试resultMap
	List<Account> findNameAndPwd();
	//测试id自增长
	int insertObject1(SysUser entity);
	//测试会改变的字符串
	//假如使用$取参数的值，此时要使用@Param注解对参数进行声明
	//当使用#获取参数数值时，假如接口方法中有多个参数，使用@Param注解进行声明
	List<Map<String, Object>> findUsers1(@Param("columnName") String columnName,@Param("phone") String phone);
}
