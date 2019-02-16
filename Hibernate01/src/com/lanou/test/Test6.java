package com.lanou.test;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.lanou.bean.Employee;
import com.lanou.bean.Project;
import com.lanou.util.HibernateUtil;

/**
 * 测试多对多查询
 * @author LiuXu
 * @time2018年8月17日下午4:07:11
 **/
public class Test6 {

	Session session;

	@Before
	public void init() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		session = factory.openSession();
	}

	/**
	 * 多对多级联操作 添加一个员工employee
	 * 并给这个员工添加两个项目
	 */
	@Test
	public void test1() {
		Transaction tx = session.beginTransaction();
		Employee employee = new Employee();
		employee.setEid(1);
		employee.setEname("王鑫");
		// 给employee添加两个project
		Project pro1 = new Project();
		pro1.setPid(1);
		pro1.setPname("进销存系统");
		Project pro2 = new Project();
		pro2.setPid(2);
		pro2.setPname("云平台系统");
		employee.getProjects().add(pro1);
		employee.getProjects().add(pro2);
		session.saveOrUpdate(employee);
		tx.commit();

	}

	/**
	 * 多对多级联修改 给2号project再添加一个employee
	 */
	@Test
	public void test2() {

		Transaction tx = session.beginTransaction();
		// 获取2号project
		Project project = (Project) session.get(Project.class, 2);
		Set<Employee> employees = project.getEmployees();
		for (Employee employee : employees) {
			System.out.println(employee.getEname());
		}
		// 给project添加一个employee
		Employee employee = new Employee();
		employee.setEid(2);
		employee.setEname("刘旭");
		employees.add(employee);
		project.setEmployees(employees);
		tx.commit();

	}

	/**
	 * 多对多级联删除
	 * 删除id为1的employee，并级联删除它所关联的数据
	 */
	@Test
	public void Test3() {
		// 开启事务
		Transaction tx = session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, 1);
		session.delete(employee);
		tx.commit();

	}

	@After
	public void close() {
		session.close();
	}

}
