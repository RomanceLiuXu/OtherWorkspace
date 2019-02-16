package com.lanou.test;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.lanou.bean.User;
import com.lanou.util.MyBatisUtil;

/**
 *
 * @author LiuXu
 * @time2018年9月18日上午9:31:55
 **/
public class TestCase1 {

	SqlSessionFactory factory;

	@Before
	public void InitialContext() {
		factory = MyBatisUtil.getSqlSessionFactory();
	}
	
	/**
	 * select * from user where username=${value}
	 */
	@Test
	public void test1(){
		SqlSession session = factory.openSession();
		User user = session.selectOne("findUserByName","'李四'");
		System.out.println("user："+user);
		session.close();
	}
	
	/**
	 * 根据账号和密码查找一个user对象
	 */
	@Test
	public void test2(){
		SqlSession session = factory.openSession();
		HashMap<String, String> map = new HashMap<>();
		map.put("username", "'李四'");
		map.put("password", "'123' or 1=1");
		List<User> user = session.selectList("u.findUserByNameAndPwd",map);
		System.out.println(user);
		
	}
	
	/**
	 * 
	 */
	@Test
	public void test3(){
		SqlSession session = factory.openSession();
		String tableName = "user";
		List<User> user = session.selectList("u.findAll",tableName);
		System.out.println(user);
		session.close();
	}
	
}
