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

public class TestSysUser01 {
	/**
	 * ÿ������ MyBatis ��Ӧ�ö�����һ�� SqlSessionFactory ��ʵ��Ϊ���ĵġ�
	 * ���SqlSessionFactory ��ʵ������ͨ�� SqlSessionFactoryBuilder
	 * ����xml�����ô�����
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
		//�ж�factory�����Ƿ�Ϊ��
		Assert.assertNotNull(factory);
		//����SQLSession����
		SqlSession session = factory.openSession();
		//�ڲ�Ϊ�����ռ�+sql id
		List<Map<String, Object>> list = session.selectList("practice.com.project.mybatis.dao.SysUserDao.findUsers");
		System.out.println(list);
		//�ͷ���Դ
		session.close();
		
		/**������
		 * 1.һ�м�¼ӳ��Ϊһ��map(ӳ����̵ײ�ʵ��)
		 * 2.���м�¼ӳ��Ϊ���map
		 * 3.���map�ٴ洢��list����(�ײ�ʵ����)
		 */
	}
	
	@Test
	public void testFindUserById(){
		SqlSession session = factory.openSession();
		Map<String, Object> map = session.selectOne("practice.com.project.mybatis.dao.SysUserDao.findUserById", 1);
		System.out.println(map);
		session.close();
	}
}
