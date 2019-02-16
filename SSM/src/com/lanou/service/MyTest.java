package com.lanou.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lanou.bean.Emp;
import com.lanou.dao.EmpMapper;

/**
 *
 * @author LiuXu
 * @time2018年9月19日下午7:22:30
 **/
public class MyTest {

	private AbstractApplicationContext ac;

	@Before
	public void init() {
		String conf = "spring.xml";
		// 构建spring容器
		ac = new ClassPathXmlApplicationContext(conf);
		System.out.println("spring容器启动");

	}

	@Test
	public void test1() {
		// SqlSessionFactory factory = (SqlSessionFactory)
		// ac.getBean("sessionFactory");
		// SqlSession session = factory.openSession();
		// EmpMapper mapper = session.getMapper(EmpMapper.class);
		// List<Emp> emps = mapper.findAll();
		// for (Emp emp : emps) {
		// System.out.println(emp);
		// }
		EmpService bean = ac.getBean("empService", EmpService.class);
		List<Emp> findAll = bean.findAll();
		for (Emp emp : findAll) {
			System.out.println(emp);
		}

	}

}
