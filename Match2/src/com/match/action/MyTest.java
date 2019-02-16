package com.match.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.liuxu.beans.Picture;
import com.liuxu.beans.User;
import com.match.util.HibernateUtil;

/**
 *
 * @author LiuXu
 * @time2018年8月18日下午1:10:09
 **/
public class MyTest {

	Session session;
	
	@Before
	public void init() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		session = factory.openSession();
		
	}
	
	@Test
	public void test1(){
	  User user =	(User) session.get(User.class, 37);
	  System.out.println(user.getPicture().getPaddress());
		
	}

	/**
	 * 插入数据
	 */
	@Test
	public void test2(){
		Transaction tx = session.beginTransaction();
		User user = new User("酒", 13, "男", "陕西西安", "1231", "12234");
		Picture picture = new Picture("男1", "/marry/test",user);
		user.setPicture(picture);
		session.save(user);
		tx.commit();
	}
	
	
	
	@After
	public void close() {
		session.close();
	}
}
