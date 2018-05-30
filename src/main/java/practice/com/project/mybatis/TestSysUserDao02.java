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
import practice.com.project.mybatis.vo.Account;


public class TestSysUserDao02 {
	/**
	 * 每个基于Mybatis的应用都是以一个SqlSessionFactory的实例为中心的。
	 */
	private SqlSessionFactory factory;
	@Before
	public void init() throws IOException{
		//SqlSessionFactory的实例可以通过SqlSessionFactoryBuilder基于xml的配置创建。
		factory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
	}
	@Test
	public void testinsert(){
		//SqlSession对象代表了一次SQL会话，包含了面向数据库执行SQL命令所需的所有方法。
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
		entity.setUsername("xiao");
		entity.setPassword("456");
		entity.setPhone("13877");
		entity.setId(7);
		int map = dao.updateObject(entity);
		session.commit();
		System.out.println(entity);
		session.close();
	}
	@Test
	public void testdelete(){
		SqlSession session = factory.openSession(false);
		SysUserDao dao = session.getMapper(SysUserDao.class);
		SysUser entity = new SysUser();
		entity.setId(8);
		int map = dao.deleteObject(entity);
		session.commit();
		System.out.println(map);
		session.close();
	}
	@Test
	public void testresultmap(){
		SqlSession session= factory.openSession();
		SysUserDao dao = session.getMapper(SysUserDao.class);
		//要想输入Acount中的值，需要重写toString方法
		List<Account> list = dao.findNameAndPwd();
		System.out.println(list);
		session.close();
	}
	//测试自增长id
	@Test
	public void testinsertObject1(){
		SqlSession session = factory.openSession(false);
		SysUserDao dao = session.getMapper(SysUserDao.class);
		SysUser entity = new SysUser();
		entity.setUsername("jiejie");
		entity.setPassword("888");
		entity.setPhone("1348569");
		
		int rows = dao.insertObject1(entity);
		session.commit();
		System.out.println("rows="+rows);
		System.out.println(entity);
		session.close();
	}
	//测试${} 传入值
	@Test
	public void testfindUsers1(){
		SqlSession session = factory.openSession();
		SysUserDao dao = session.getMapper(SysUserDao.class);
		List<Map<String, Object>> list=dao.findUsers1("id","139");
		System.out.println(list);
		session.close();
	}
}
