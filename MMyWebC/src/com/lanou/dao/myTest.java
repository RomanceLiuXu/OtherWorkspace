package com.lanou.dao;

import java.util.AbstractCollection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.lanou.bean.Student;
import com.lanou.util.HibernateUtil;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 *
 * @author LiuXu
 * @time2018年8月27日下午4:37:38
 **/
public class myTest {
	
	private AbstractApplicationContext ac;
	@Before
	public void init() {
		String conf = "applicationContext.xml";
		// 构建spring容器
		ac = new ClassPathXmlApplicationContext(conf);
		System.out.println("spring容器启动");
	}

	@Test
	public void test1(){
	StudentDaoImpl stu = ac.getBean("studentDao",StudentDaoImpl.class);
	List<Student> students = stu.findStudent(1, 2);
	System.out.println(students.get(0).getName());
	long n = stu.findStuNum();
	System.out.println(n);
	}
	
}
