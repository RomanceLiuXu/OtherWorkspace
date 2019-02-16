package com.lanou.util;

//静态引入，把这个类里面的所有的静态方法引入
//如果调用类中静态方法或变量不需要带类名
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * junit3及其以下需要实现
 * 
 * @author LiuXu
 * @time2018年9月29日下午2:41:27
 **/
public class CalculateTest{
	@Test
	public void testAdd() {
		// 断言
		// 第一个参数是我们的预期结果，
		// 第二个参数是方法实际运行的结果
		assertEquals(10, new Calculate().add(3, 7));
		assertEquals(5, new Calculate().division(5, 0));
	}
  
}
