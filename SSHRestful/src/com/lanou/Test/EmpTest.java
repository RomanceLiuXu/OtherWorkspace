package com.lanou.Test;

import java.util.List;

import javax.websocket.Session;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lanou.bean.Emp;
import com.lanou.dao.EmpDaoImpl;

/**
 *
 * @author LiuXu
 * @time2018年9月9日下午2:19:16
 **/
public class EmpTest {
	AbstractApplicationContext ac;

	@Before
	public void init() {
		String conf = "spring.xml";
		ac = new ClassPathXmlApplicationContext(conf);
	}
	
	@Test
	public void test1(){
		EmpDaoImpl dao = ac.getBean("empDao", EmpDaoImpl.class);
		List<Emp> all = dao.findPageAll(1, 3);
		for (Emp emp : all) {
			System.out.println(emp);
		}
		long s = dao.findAllNums();
		System.out.println(s);
	}
	
}
