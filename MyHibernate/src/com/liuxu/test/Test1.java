package com.liuxu.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.liuxu.hibernate.Dept;

/**
 * Hibernate进行数据库的操作
 * 
 * @author LiuXu
 * @time2018年8月15日下午8:29:59
 **/
public class Test1 {

	public static void main(String[] args) {
		// 读取hibernate.cfg.xml文件
		// 实例化
		Configuration cfg = new Configuration();
		// 加载配置文件
		cfg.configure("hibernate.cfg.xml");
		// 获取session工厂对象
		SessionFactory factory = cfg.buildSessionFactory();
		// add(factory);
		// update(factory);
		// select(factory);
		delete(factory);
	}

	/**
	 * 删除数据
	 * @param factory
	 */
	private static void delete(SessionFactory factory) {
		Session session = factory.openSession();
		Transaction ts = session.beginTransaction();
		Dept dept = (Dept) session.get(Dept.class, 6);
		 if (dept!=null) {
			 session.delete(dept);
			 ts.commit();
		 }else{
	        ts.rollback();
		 }
		session.close();
	}

	private static void select(SessionFactory factory) {
		Session session = factory.openSession();
		Transaction ts = session.beginTransaction();
		// Dept dept = (Dept) session.get(Dept.class, 8);
		Dept dept = (Dept) session.load(Dept.class, 6);
		ts.commit();
		System.out.println(dept.getDeptId() + ":" + dept.getDeptLocation());
		session.close();

	}

	/**
	 * 修改的方法
	 * 
	 * @param factory
	 */
	private static void update(SessionFactory factory) {
		Session session = factory.openSession();
		Transaction ts = session.beginTransaction();
		session.saveOrUpdate(new Dept(6, "规划部", "广州"));
		ts.commit();
		session.close();
	}

	/**
	 * 添加数据的方法
	 * 
	 * @param factory
	 */
	private static void add(SessionFactory factory) {

		// 获取session对象
		Session session = factory.openSession();
		// 开启事务
		Transaction ts = session.beginTransaction();
		// 调用save方法
		session.save(new Dept(6, "风险投资部", "上海"));
		// 提交事务
		ts.commit();
		// 关闭
		session.clear();
	}

}
