package practice.com.project.mybatis.dao;

import java.util.List;
import java.util.Map;

public interface SysUserDao {
	List<Map<String, Object>> findUsers();
	Map<String, Object> findUserById(Integer id);
	int insertObject(SysUser entity);
}
