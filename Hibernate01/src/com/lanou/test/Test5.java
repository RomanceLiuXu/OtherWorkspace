package com.lanou.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lanou.bean.Book;
import com.lanou.bean.Student;
import com.lanou.util.HibernateUtil;

/**
 * 测试一对多和多对一的级联操作
 * 
 * 
 * @author LiuXu
 * @time2018年8月17日上午9:48:30
 **/
public class Test5 {

	Session session;

	@Before
	public void init() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		session = factory.openSession();
	}

	/**
	 * 一对多的级联查询 get()/load()都会延迟加载出其关联的多方信息
	 * get()只会加载出本类对象的所有信息,只有当需要使用到多方集合信息中的数据时，才会发送sql语句去执行查询
	 */
	@Test
	public void test1() {
		// 查询id为1的学生有哪些书
		// 查询id为1的学生对象
		Student student = (Student) session.get(Student.class, 1);
		System.out.println(student);
		System.out.println(student.getName());
		Set<Book> books = student.getBooks();
		for (Book book : books) {
			System.out.println(book.getName());
		}

	}

	/**
	 * 一对多的级联添加
	 */
	@Test
	public void test1_1(){
		Transaction tx = session.beginTransaction();
		Student student = new Student(8, "liuxu");
		Book book = new Book(6, "sss", "ss");
		student.getBooks().add(book);
		session.save(student);
		tx.commit();
	}
	
	/**
	 * 一对多的级联修改
	 */
	@Test
	public void test2() {
		// 开启事务
		Transaction tx = session.beginTransaction();
		// 获取id为2的学生信息
		Student student = (Student) session.get(Student.class, 2);
		// 给当前学生添加两本书
		Book book1 = new Book(3, "完美世界", "辰东");
		Book book2 = new Book(4, "三体", "刘慈恩");
		student.getBooks().add(book1);
		student.getBooks().add(book2);
		tx.commit();
	}

	/**
	 * 多对一的级联修改
	 */
	@Test
	public void test3() {
		Transaction tx = session.beginTransaction();
		// 创建一本图书
		Book book = new Book(5, "武动乾坤", "凤临天下");
		Student student = (Student) session.get(Student.class, 2);
		book.setStudent(student);
		// 插入数据，使临时态转换为持久态
		session.save(book);
		tx.commit();
	}

	/**
	 * 多对一的级联查询
	 */
	@Test
	public void test4() {
		Book book = (Book) session.get(Book.class, 2);
		System.out.println(book);
	}

	/**
	 * 多对一的级联删除
	 * 1.先查这本书的外键b_studentid
	 * 2.通过外键b_studentid查询它关联的学生(s_id)
	 * 3.在从book中查询哪些图书的b_studentid等于s_id
	 * 4.删除这些book
	 * 5.在删除这个student
	 */
	@Test
	public void test5() {
		Transaction tx = session.beginTransaction();
		// 获取book对象
		Book book = (Book) session.get(Book.class, 2);
        session.delete(book);
        tx.commit();
	}

	@After
	public void close() {
		session.close();
	}

}
