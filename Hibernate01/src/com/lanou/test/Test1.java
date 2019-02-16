package com.lanou.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.lanou.bean.Dept;

/**
 * 使用session对象对数据库进行一系列的操作
 * @author LiuXu
 * @time2018年8月15日下午2:44:33
 **/
public class Test1 {

	public static void main(String[] args) {
		// 加载Hibernate主配置文件
		Configuration cfg = new Configuration();
		// 加载配置文件
		cfg.configure("hibernate.cfg.xml");
		// 获取SessionFactory工厂对象
		SessionFactory factory = cfg.buildSessionFactory();
		// add(factory);
		// update(factory);
		// select1(factory);
		delete(factory);
	}

	
	
	
	
	/**
	 * 删除一个对象
	 * 
	 * @param factory
	 */
	private static void delete(SessionFactory factory) {
		// 获取session对象
		Session session = factory.openSession();
		// 开启事务
		Transaction ts = session.beginTransaction();
		// 根据id查找要删除的对象
		Dept dept = (Dept) session.get(Dept.class, 1);
		// 执行删除
		session.delete(dept);
		// 提交事务
		ts.commit();
		// 关闭session
		session.close();
	}

	/**
	 * 根据id查询一个对象
	 * get():只要方法调用就会立即发送sql语句 
	 * load():延迟加载，只有方法调用查询对象的非id属性时才会打印sql语句
	 * 
	 * @param factory
	 */
	private static void select1(SessionFactory factory) {
		// 获取session对象
		Session session = factory.openSession();
		// 直接根据id查询一个对象
		Dept dept = (Dept) session.get(Dept.class, 1);
		// 延迟加载
		// Dept dept = (Dept) session.load(Dept.class, 10);
		// System.out.println(dept.getDeptNo());
		System.out.println(dept.getDeptName());
		// 关闭session
		session.close();
	}

	/**
	 * 通过session对象修改数据
	 * 
	 * @param factory
	 */
	private static void update(SessionFactory factory) {
		// 获取session对象
		Session session = factory.openSession();
		// 开启事务
		Transaction ts = session.beginTransaction();
		// 创建一个对象
		Dept dept = new Dept(3, "资金回收部", "北京");
		// 先查看数据库表中是否有数据，没有就插入
		// 有的话先查看数据是否一致，一致不做任何操作，不一致就进行修改
		session.saveOrUpdate(dept);
		// 提交事务
		ts.commit();
		// 关闭session
		session.close();
	}

	/**
	 * 添加数据
	 * @param factory
	 */
	private static void add(SessionFactory factory) {
		// 通过工厂获取session对象（org.hibernate包下的）
		Session session = factory.openSession();
		// 开启事务
		Transaction ts = session.beginTransaction();
		// 使用session往数据库中插入一条数据
		session.save(new Dept(2, "小王", "西安"));
		ts.commit();
		// 关闭session
		session.close();
	}

}
