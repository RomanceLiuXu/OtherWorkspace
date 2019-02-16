package com.lanou.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lanou.bean.Book;
import com.lanou.bean.Card;
import com.lanou.bean.Employee;
import com.lanou.bean.Project;
import com.lanou.bean.Student;
import com.lanou.bean.User;
import com.lanou.util.HibernateUtil;

/**
 * 级联查询
 * 
 * @author LiuXu
 * @time2018年8月17日下午8:34:39
 **/
public class MyTest8 {

	Session session;

	@Before
	public void init() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		session = factory.openSession();
	}

	/**
	 * 一对多的级联添加
	 */
	@Test
	public void test1() {
		// 开启事务
		Transaction tx = session.beginTransaction();
		// 实例化
		Student student = new Student(3, "小明");
		student.getBooks().add(new Book(7, "Java面试", "程序员"));
		student.getBooks().add(new Book(8, "Java", "程序员2号"));
		session.save(student);
		tx.commit();
	}

	/**
	 * 多对一级联添加 给id为7的书再添加一个学生
	 */
	@Test
	public void test2() {

		Transaction tx = session.beginTransaction();
		Book book = (Book) session.get(Book.class, 7);
		book.setStudent(new Student(4, "小李"));
		tx.commit();

	}

	/**
	 * 一对多的级联删除
	 * 
	 */
	@Test
	public void test3() {
		Transaction tx = session.beginTransaction();
		Student student = (Student) session.get(Student.class, 2);
		session.delete(student);
		tx.commit();
	}

	/**
	 * 多对多的级联添加 新建一个Employee，并添加两个项目Project
	 */
	@Test
	public void test4() {
		Transaction tx = session.beginTransaction();
		// 实例化
		Employee employee = new Employee(1, "小王");
		// 实例化项目并级联添加
		employee.getProjects().add(new Project(1, "数据管理系统"));
		employee.getProjects().add(new Project(2, "环境监测系统"));
		session.save(employee);
		tx.commit();
	}

	/**
	 * 多对多的级联添加
	 * 给编号为1项目正在添加两个Employee员工
	 */
	@Test
     public void test5(){
		Transaction tx = session.beginTransaction();
		Project project = (Project) session.get(Project.class, 1);
		project.getEmployees().add(new Employee(2, "小黄"));
		project.getEmployees().add(new Employee(3, "小周"));
		tx.commit();
     }
	
	/**
	 * 多对多的级联删除
	 * 删除项目1
	 */
	@Test
	public void test6(){
		Transaction tx = session.beginTransaction();
	    Project project =  (Project) session.get(Project.class, 1);
	    session.delete(project);
	    tx.commit();
	}
	
	/**
	 * 一对一级联操作
	 * 新建一个用户User并给他添加身份证
	 */
	@Test
	public void test7() {
	 Transaction tx = session.beginTransaction();
	 User user = new User(3, "姜老师", "陕西",new Card(3, "987"));
	session.save(user);
	tx.commit();
	}
	
	/**
	 * 一对一的级联修改
	 */
	@Test
	public void test8(){
		Transaction tx = session.beginTransaction();
		User user =  (User) session.get(User.class, 1);
		user.getCard().setcNo("123");
		tx.commit();
		
	}
	
	@After
	public void close() {
		session.close();
	}

}
