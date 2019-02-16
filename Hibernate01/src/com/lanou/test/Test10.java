package com.lanou.test;

import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.junit.Test;

import com.lanou.bean.Book;
import com.lanou.bean.Dept;
import com.lanou.bean.Student;
import com.lanou.util.HibernateUtil;

/**
 * Session缓存
 * 
 * @author LiuXu
 * @time2018年8月20日下午3:00:55
 **/
public class Test10 {

	/**
	 * 一级缓存 两个不同session共用了一级缓存中的数据
	 */
	@Test
	public void test1() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		// 第一次向数据库发送sql语句执行查询
		// 并将查询结果存入到session缓存中
		Dept dept = (Dept) session.get(Dept.class, 2);
		System.out.println(dept);
		System.out.println("----------第二次取数据-----------");
		// 第二次是从缓存中取的数据
		Dept dept2 = (Dept) session.get(Dept.class, 2);
		System.out.println(dept2);
		session.close();
	}

	/**
	 * 二级缓存
	 */
	@Test
	public void test2() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session1 = factory.openSession();
		// 将查到的数据存入一级缓存session和二级缓存
		Student student = (Student) session1.get(Student.class, 3);
		System.out.println(student.getSid() + ":" + student.getName());
		Set<Book> books = student.getBooks();
		for (Book book : books) {
			System.out.println(book.getBid() + ":" + book.getName());
		}
		// 关闭session（一级缓存数据消失）
		session1.close();

		System.out.println("----------第二个session查询---------");
		Session session2 = factory.openSession();
		// 将查到的数据存入一级缓存session和二级缓存
		Student student2 = (Student) session2.get(Student.class, 3);
		System.out.println(student2.getSid() + ":" + student2.getName());
		Set<Book> books2 = student2.getBooks();
		for (Book book : books2) {
			System.out.println(book.getBid() + ":" + book.getName());
		}
		session2.close();
	}

	/**
	 * 查询缓存
	 */
	@Test
	public void test3() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		String hql = "select name from Student where sid=?";
		Query query = session.createQuery(hql);
		query.setInteger(0, 3);
		// 从查询缓存中取数据，如果查询缓存中没有数据，就发送sql语句到数据库中执行查询，
		// 然后将sql语句和查询结果以key-value的键值对形式存储在查询缓存中
		query.setCacheable(true);
		String string = (String) query.uniqueResult();
		System.out.println("name:" + string);

		System.out.println("--------重新查询学生姓名-------");

		String hql2 = "select name from Student where sid=?";
		Query query2 = session.createQuery(hql2);
		query2.setInteger(0, 3);
		query2.setCacheable(true);
		String string2 = (String) query2.uniqueResult();
		System.out.println("name:" + string2);

	}
}
