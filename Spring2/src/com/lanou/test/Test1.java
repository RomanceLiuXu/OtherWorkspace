package com.lanou.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lanou.action.EmpAction;
import com.lanou.bean.School;
import com.lanou.bean.Student;
import com.lanou.bean.Teacher;
import com.liuxu.Demo;

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

	@Test
	public void test1() {
		// // 构建bean组件对象
		// MessageBean bean = ac.getBean("msg", MessageBean.class);
		// MessageBean bean1 = ac.getBean("msg", MessageBean.class);
		// System.out.println(bean);
		// System.out.println(bean1);
		// ac.close();
	}

	@Test
	public void test2() {
		Student student = ac.getBean("stu", Student.class);
		Teacher teacher = ac.getBean("tea", Teacher.class);
		School sch = ac.getBean("sch", School.class);
		student.show();
		teacher.show();
		sch.show();
	}

	/**
	 * springjdbc测试
	 */
	@Test
	public void test3() {
//		EmpDao dao = ac.getBean("empDao", EmpDaoImpl.class);
		// List<Emp> emps = dao.findAll();
		// for (Emp emp : emps) {
		// System.out.println(emp);
		//// }
		// Emp emp = dao.findEmpById(2);
		// System.out.println(emp);
		//
		// dao.deleteEmpById(5);
		//
		// Emp emp2 = new Emp("王鑫", "司机", 10000.0, new Date());
		// dao.save(emp2);

		// Emp emp = dao.findEmpById(4);
		// emp.setName("666");
		// emp.setSalary(13000);
		// dao.update(emp);

		EmpAction action = ac.getBean("empAction", EmpAction.class);
		action.execute();
	}

	

}
