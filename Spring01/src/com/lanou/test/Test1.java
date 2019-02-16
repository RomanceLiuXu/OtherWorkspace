package com.lanou.test;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lanou.bean.ExampleBean;
import com.lanou.bean.MessageBean;
import com.lanou.bean.School;
import com.lanou.bean.Student;
import com.lanou.bean.Teacher;

/**
 *
 * @author LiuXu
 * @time2018年8月21日下午3:50:23
 **/
public class Test1 {

	// ApplicationContext ac;
	// 向下转型
	AbstractApplicationContext ac;

	/** 实例化spring容器 */
	@Before
	public void init() {
		String conf = "applicationContext.xml";
		// 构建spring容器
		ac = new ClassPathXmlApplicationContext(conf);
		System.out.println("spring容器启动");
	}

	/** spring管理对象的创建方式 */
	@Test
	public void test1() {
		// 构建bean组件对象
		Calendar c1 = ac.getBean("c1", GregorianCalendar.class);
		Calendar c2 = ac.getBean("c2", Calendar.class);
		Date date = ac.getBean("date", Date.class);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(date);
	}

	/**
	 * spring容器管理bean的作用域
	 * init-method=""
	 * destroy-method=""
	 */
	@Test
	public void test2() {
		ExampleBean exam = ac.getBean("exam", ExampleBean.class);
		ExampleBean exam2 = ac.getBean("exam", ExampleBean.class);
		System.out.println(exam);
		System.out.println(exam2);
		ac.close();
	}
	
	/**
	 * 依赖注入给对象的属性赋值
	 */
	@Test
	public void test3(){
		Student student = ac.getBean("stu", Student.class);
		student.show();
		  
	     Teacher teacher = ac.getBean("tea",Teacher.class);
	     teacher.show();
	     
	     School sc = ac.getBean("sch", School.class);
	     sc.show();
	}
	
	
	/**
	 * 不同类型值的注入
	 */
    @Test 
	public void test4(){
    	    MessageBean msg = ac.getBean("msg1",MessageBean.class);
    	    msg.show();
     }
	
}
