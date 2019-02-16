package com.liuxu.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lanou.util.HibernateUtil;
import com.liuxu.hibernate.Book;
import com.liuxu.hibernate.Card;
import com.liuxu.hibernate.Employee;
import com.liuxu.hibernate.Project;
import com.liuxu.hibernate.Student;
import com.liuxu.hibernate.User;

/**
 * 注解的用法
 * 
 * @author LiuXu
 * @time2018年8月21日下午9:07:13
 **/
public class Test3 {
	
	Session session;

	@Before
	public void init() {
		// 注解版测试初始化
		Configuration cfg = new AnnotationConfiguration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		session = factory.openSession();
	}

	/**
	 * 一对多注解 查询
	 */
	@Test
	public void test1() {
		Student student = (Student) session.get(Student.class, 4);
		System.out.println(student.toString());
	}

	/**
	 * 一对多注解 添加
	 */
	@Test
	public void test2() {
		Transaction tx = session.beginTransaction();
		Student student = new Student(12, "小花");
		Set<Book> books = new HashSet<>();
		books.add(new Book(10, "哈哈", "kk"));
		student.setBooks(books);
		session.save(student);
		tx.commit();
		session.close();
	}

	/**
	 * 多对多注解 添加
	 */
	@Test
	public void test3() {
		Transaction tx = session.beginTransaction();
		Employee employee = new Employee(12, "小李");
		employee.getProjects().add(new Project(12, "管理系统"));
		employee.getProjects().add(new Project(13, "旅游系统"));
		session.save(employee);
		tx.commit();
	}

	/**
	 * 一对一双向主键关联
	 */
	@Test
	public void test4() {
		// User user = (User) session.get(User.class,1);
		// System.out.println(user.getCard().getcNo());
		Transaction tx = session.beginTransaction();
		User user = new User(8, "小周", "陕西", new Card(8, "1234"));
		session.saveOrUpdate(user);
		tx.commit();

	}

	@After
	public void close() {
		session.close();
	}
}
