package com.liuxu.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import com.lanou.util.HibernateUtil;
import com.liuxu.hibernate.Dept;

/**
 * Junit单元测试（3种状态）
 * 
 * @author LiuXu
 * @time2018年8月15日下午9:08:22
 **/
public class Test2 {

	SessionFactory factory;

	@Before
	public void init() {
		factory = HibernateUtil.getSessionFactory();
	}

	@Test
	public void myTest() {
		Session session = factory.openSession();
		session.beginTransaction();
		// Dept dept = (Dept) session.load(Dept.class, 2);
		// dept.setDeptLocation("杭州");
		// // 此时由持久态变为游离态，上面的代码不会执行
		// session.clear();
		Dept dept = new Dept();
		// dept.setDeptId(2);
		dept.setDeptName("营销部");
		session.saveOrUpdate(dept);
		session.beginTransaction().commit();
	}

	/**
	 * 临时状态(瞬时态)
	 * 
	 */
	@Test
	public void test1() {

	}

	/**
	 * 持久态
	 */
	@Test
	public void test2() {

	}

	/**
	 * 游离态
	 */
	@Test
	public void test3() {

	}
}
