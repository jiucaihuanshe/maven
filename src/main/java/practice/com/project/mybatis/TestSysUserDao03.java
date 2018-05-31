package practice.com.project.mybatis;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import practice.com.project.mybatis.dao.SysUser;
import practice.com.project.mybatis.dao.SysUserDao;

public class TestSysUserDao03 {
	private SqlSessionFactory factory;
	@Before
	public void init() throws IOException{
		factory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("mybatis-config.xml"));
	}
	@Test
	public void testfindUsersByIf(){
		SqlSession session = factory.openSession();
		SysUserDao dao = session.getMapper(SysUserDao.class);
		List<SysUser> list = dao.findUsersByIf(1,"n", "139");
		System.out.println(list);
		session.close();
	}
	@Test
	public void testdeleteForeach(){
		SqlSession session = factory.openSession(false);
		SysUserDao dao = session.getMapper(SysUserDao.class);
		String[] ids = {"14"};
		int rows = dao.deleteForeach(ids);
		session.commit();
		System.out.println("rows="+rows);
		session.close();
	}
}
