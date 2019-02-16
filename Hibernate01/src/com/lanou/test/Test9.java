package com.lanou.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.lanou.bean.Dept;
import com.lanou.util.HibernateUtil;

/**
 * 测试openSession()和getCurrentSesion()
 * 
 * 例如JDBC中获取Connection对象中中要使用的ThreadLocal 
 * ThreadLocal<Connection> thread = new ThreadLocal(); 
 * 方法:get():从当前线程获取绑定的对象
 * set():给当前线程绑定对象 
 * remove():从当前线程移出绑定对象
 * 
 * 集群：横向的复制（例如游戏的分区）
 * 分布式：横向的切分（各个服务器的功能模块不一样）
 * 
 * @author LiuXu
 * @time2018年8月20日上午11:10:04
 **/
public class Test9 {
	@Test
	public void test1() {
		// 获取一个session对象
		SessionFactory factory = HibernateUtil.getSessionFactory();
		// 从当前线程获取session对象，如果当前线程没有则创建一个并绑定到当前线程
		Session session = factory.getCurrentSession();
        //开启事务 在使用getCurrentSession()方法时需要开启事务
		Transaction tx = session.beginTransaction();
		Dept dept = (Dept) session.get(Dept.class, 1);
		System.out.println(dept);
		// 提交事务
		tx.commit();
        //在提交事务时，已自动关闭session，不需要自动关闭
		// session.close();
	}

}
