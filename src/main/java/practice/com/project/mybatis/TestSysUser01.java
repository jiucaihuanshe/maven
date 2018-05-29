package practice.com.project.mybatis;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import practice.com.project.mybatis.dao.SysUser;
import practice.com.project.mybatis.dao.SysUserDao;

public class TestSysUser01 {
	/**
	 * 每个基于 MyBatis 的应用都是以一个 SqlSessionFactory 的实例为中心的。
	 * 这个SqlSessionFactory 的实例可以通过 SqlSessionFactoryBuilder
	 * 基于xml的配置创建。
	 */
	private SqlSessionFactory factory;
	@Before
	public void init() throws IOException{
		factory = new SqlSessionFactoryBuilder()
			.build(Resources.getResourceAsStream("mybatis-config.xml"));
			/*.build(getClass().getClassLoader().getResourceAsStream("mybatis-config.xml"));*/
	}
	@Test
	public void testFindUsers(){
		//System.out.println(factory);
		//判断factory对象是否为空
		Assert.assertNotNull(factory);
		//创建SQLSession对象
		SqlSession session = factory.openSession();
		//内部为命名空间+sql id
		List<Map<String, Object>> list = session.selectList("practice.com.project.mybatis.dao.SysUserDao.findUsers");
		System.out.println(list);
		//释放资源
		session.close();
		
		/**分析：
		 * 1.一行记录映射为一个map(映射过程底层实现)
		 * 2.多行记录映射为多个map
		 * 3.多个map再存储到list集合(底层实现了)
		 */
	}
	
	@Test
	public void testFindUserById(){
		SqlSession session = factory.openSession();
		Map<String, Object> map = session.selectOne("practice.com.project.mybatis.dao.SysUserDao.findUserById", 1);
		System.out.println(map);
		session.close();
	}
	@Test
	public void testinsertObject(){
		//false表示事务需要手动提交
		SqlSession session = factory.openSession(false);
		SysUserDao dao = session.getMapper(SysUserDao.class);
		SysUser entity = new SysUser();
		entity.setUsername("tedu");
		entity.setPassword("123");
		entity.setPhone("1234565");
		int rows = dao.insertObject(entity);
		session.commit();//提交事务
		System.out.println("rows="+rows);
		session.close();
	}
}
