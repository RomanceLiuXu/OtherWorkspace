package com.lanou.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lanou.bean.Card;
import com.lanou.bean.Employee;
import com.lanou.bean.Project;
import com.lanou.bean.User;
import com.lanou.util.HibernateUtil;

/**
 *  一对一的级联操作
 * @author LiuXu
 * @time2018年8月17日下午4:07:11
 **/
public class Test7 {

	Session session;

	@Before
	public void init() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		session = factory.openSession();
	}

	/**
	 * 一对一的级联添加
	 */
	@Test
	public void test1(){
		Transaction tx = session.beginTransaction();
		User user = new User(1, "小美", "陕西",new Card(1, "610"));
		session.save(user);
		tx.commit();
	}
	@Test
	public void test2(){
		
	}
	@Test
	public void test3(){
		
	}
	
	@After
	public void close() {
		session.close();
	}

}
