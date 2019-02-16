package com.lanou.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;

import org.apache.ibatis.jdbc.Null;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.lanou.bean.User;
import com.lanou.bean.User1;
import com.lanou.util.MyBatisUtil;

/**
 *
 * @author LiuXu
 * @time2018年9月17日上午11:42:11
 **/
public class TestCase {

	SqlSessionFactory factory;

	@Before
	public void InitialContext() {
		factory = MyBatisUtil.getSqlSessionFactory();
	}

	// 查找单个对象
	@Test
	public void test1() throws FileNotFoundException {
		// 1.获取sqlSessionFactory对象
		// 记载mybatis配置文件
		// new FileInputStream("src/SqlMapConfig.xml") 不通用
		// 通过类加载器对象获取一个流
		// 每个应用对应唯一的一个SqlSessionFactory
		// 可以用于构建SqlSesion对象和充当二级缓存
		// 用于操作数据库，以及充当一级缓存的对象
		SqlSession session = factory.openSession();
		// 通过session对象执行映射文件中的sql语句
		// 第一个参数：sql定义的id
		// 第二个参数：传入的占位符的参数值
		User user = session.selectOne("findUserById", 1);
		System.out.println(user.toString());
	}

	/**
	 * 查找所有对象封装在list集合中 如果多个映射文件中有相同的sql定义id，可以使用namespace名.id名来查找定义sql
	 */
	@Test
	public void test2() {
		SqlSession session = factory.openSession();
		List<User> users = session.selectList("user.findAll");
		for (User user : users) {
			System.out.println(user);
		}
		session.close();
	}

	/**
	 * 往数据库中插入一个user对象
	 */
	@Test
	public void test3() {
		SqlSession session = factory.openSession();
		User user = new User("田七", "123", 12, "男");
		int rows = session.insert("saveUser", user);
		System.out.println("成功插入的行数:" + rows);
		// 提交事务
		session.commit();
		// 关闭session
		session.close();
	}

	/**
	 * 根据id删除一个user对象 
	 */
	@Test
	public void test4() {
		SqlSession session = factory.openSession();
		int rows = session.delete("deleteUserById", 6);
		System.out.println("删除的行数:" + rows);
		session.commit();
		session.close();
	}

	/**
	 * 根据id修改一行记录
	 */
	@Test
	public void test5() {
		SqlSession session = factory.openSession();
		User user = session.selectOne("findUserById", 1);
		user.setUsername("66666");
		user.setPassword("12345");
		user.setAge(30);
		user.setGender("女");
		int rows = session.update("updateUser", user);
		System.out.println("修改的行数:" + rows);
		session.commit();
		session.close();
	}

	/**
	 * 根据名字进行模糊查询 _:代表一个字符 %:代表任意的0到多个字符
	 */
	@Test
	public void test6() {
		SqlSession session = factory.openSession();
		List<User> users = session.selectList("findUserLikeName", "_四%");
		for (User user : users) {
			System.out.println(user);
		}
		session.close();
	}

	/**
	 * 根据账号和密码查询
	 */
	@Test
	public void test7() {
		SqlSession session = factory.openSession();
		// 传入实体对象
		// User user = new User();
		// user.setUsername("李四");
		// user.setPassword("123");
		// User u = session.selectOne("findUserByNameAndPsw", user);
		// System.out.println(u);
		// 传入一个map集合
		Map<String, String> map = new HashMap<>();
		map.put("username", "李四");
		map.put("password", "123");
		User u = session.selectOne("findUserByNameAndPsw", map);
		System.out.println(u);
		session.close();
	}

	/**
	 * 查询某个用户的账号和密码
	 */
	@Test
	public void test8() {
		SqlSession session = factory.openSession();
		Map<String, String> user = session.selectOne("findNameAndPsw", 1);
		System.out.println(user);
		session.close();
	}

	/**
	 * 查询所有用户的账号和密码
	 */
	@Test
	public void test9() {
		SqlSession session = factory.openSession();
		List<User> users = session.selectList("findAllNameAndPsw");
		for (User user : users) {
			System.out.println(user);
		}
		session.close();
	}

	/**
	 * 实体类属性名与表中字段名不一致的查询
	 */
	@Test
	public void test10() {
		SqlSession session = factory.openSession();
		List<User1> users = session.selectList("findUser1");
		for (User1 user1 : users) {
			System.out.println(user1);
		}
		session.close();
	}

	/**
	 * 根据账号和密码查询一个用户信息进行登录 如果能查到数据，登录成功 
	 * 如果查不到，说明账号或密码不匹配，登录失败
	 * 模拟sql注入
	 * @throws SQLException
	 */
	@Test
	public void testJdbc() throws SQLException {
		try {
			String username = "李四1";
			String password = "1236 'or'1=1";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/mybatis?useUnicode=true&characterEncoding=utf8", "root", "123456");
			String sql = "select * from user where username='" + username + "' and password='" + password + "'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				System.out.println("登录成功");
			} else {
				System.out.println("登录失败");
			}
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
	}
    
	/**
	 * 分页查询
	 */
	@Test
	public void test11(){
		SqlSession session = factory.openSession();
		Map<String, Integer> map = new HashMap<>();
		map.put("pageIndex", 2);
		map.put("pageNum", 2);
		List<User> users = session.selectList("findUserByPage", map);
		for (User user : users) {
			System.out.println(user);
		}
		session.close();
	}
	  
	/**
	 * 查询总的记录条数
	 */
	@Test
	public void test12(){
		SqlSession session = factory.openSession();
		int rows = session.selectOne("findAllRows");
		System.out.println(rows);
	}
	
	/**
	 * 分页查询
	 * 使用RowBounds实现
	 */
	@Test
	public void test13(){
		SqlSession session = factory.openSession();
		List<User> users = session.selectList("findAll", null, new RowBounds(0, 2));
		for (User user : users) {
			System.out.println(user);
		}
	}
}
