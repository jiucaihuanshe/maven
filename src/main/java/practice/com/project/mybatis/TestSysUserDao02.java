package practice.com.project.mybatis;
/**
 * mybatis的增删改查
 */
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import practice.com.project.mybatis.dao.SysUser;
import practice.com.project.mybatis.dao.SysUserDao;

public class TestSysUserDao02 {
	private SqlSessionFactory factory;
	@Before
	public void init() throws IOException{
		factory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
	}
	@Test
	public void testinsert(){
		SqlSession session = factory.openSession(false);
		SysUserDao dao =session.getMapper(SysUserDao.class);
		SysUser entity = new SysUser();
		entity.setUsername("hong");
		entity.setPassword("123");
		entity.setPhone("13934");
		int rows = dao.insertObject(entity);
		session.commit();
		System.out.println("rows="+rows);
		session.close();
	}
	@Test
	public void testselect(){
		SqlSession session = factory.openSession();
		SysUserDao dao = session.getMapper(SysUserDao.class);
		List<Map<String, Object>> list=dao.findUsers();
		System.out.println(list);
		session.close();
	}
	@Test
	public void testupdate(){
		SqlSession session = factory.openSession(false);
		SysUserDao dao = session.getMapper(SysUserDao.class);
		SysUser entity = new SysUser();
		entity.setUsername("xiao1");
		entity.setPassword("456");
		entity.setPhone("13877");
		entity.setId(8);
		int map = dao.updateObject(entity);
		session.commit();
		System.out.println(entity);
		session.close();
	}
}
