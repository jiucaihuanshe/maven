package practice.com.project.mybatis;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestSysUserDao02 {
	private SqlSessionFactory factory;
	@Before
	public void init() throws IOException{
		factory=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
	}
	@Test
	public void testFactory(){
		Assert.assertNotNull(factory);
	}
}
