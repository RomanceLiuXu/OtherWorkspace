package com.sumi.dao.impl;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sumi.bean.Department;
import com.sumi.bean.Employee;

import junit.framework.TestCase;

/**
 *
 * @author LiuXu
 * @time2018年8月28日下午5:41:04
 **/
public class MyTest{

	private AbstractApplicationContext ac;

	@Before
	public void init() {
		String conf = "applicationContext.xml";
		// 构建spring容器
		ac = new ClassPathXmlApplicationContext(conf);
		System.out.println("spring容器启动");
	}

	@Test
	public void test1() {
		EmployeeDaoImpl e = ac.getBean("employeeDao", EmployeeDaoImpl.class);
		// List<Employee> employees = e.pageEmployee(1, 2);
		// long allPage = e.allPage(1);
		// System.out.println("总页数:"+allPage);
		// System.out.println(employees.get(0));
		// Set<Employee> ex = d.DeptEmployees1("开发部").get(0).getEmployees();
		// for (Employee employee : ex) {
		// System.out.println(employee.getEmail());
		// }
		// System.out.println(ex.toString());
//        long allPage = e.allPage("开发部");
//        System.out.println(allPage);
		DeptDaoImpl d = ac.getBean("deptDao", DeptDaoImpl.class);
		Set<Employee> employees = d.findDeptByName("销售部").getEmployees();
		for (Employee employee : employees) {
			System.out.println(employee.getUname());
		}
		
	}

}
