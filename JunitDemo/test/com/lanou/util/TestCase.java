package com.lanou.util;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author LiuXu
 * @time2018年9月29日下午2:54:17
 **/
public class TestCase {

	// 只会执行一次
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("@BeforeClass");
	}

	// 只会执行一次
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("@AfterClass");
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("@Before");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("@After");
	}

	// 超出了指定时间之后，该测试方式结束
	@Test(timeout=1000)
	public void test1() {
		int c = 1;
		System.out.println("@Test1");
		while (true) {
			c++;
			System.out.println("c的值:"+c);
		}
	}

    //忽略测试中出现的某个异常
	@Test(expected = ArithmeticException.class)
	public void test2() {
		assertEquals(5, new Calculate().division(5, 0));
		System.out.println("@Test2");
	}
}
