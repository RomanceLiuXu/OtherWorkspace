package com.lanou.util;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * 参数化设置：一次给测试方式提供多组数据进行测试
 * 
 * @author LiuXu
 * @time2018年9月29日下午3:07:53
 **/
@RunWith(Parameterized.class)
public class ParameterTest {
	int result;
	int param1;
	int param2;

	public ParameterTest(int result, int param1, int param2) {
		super();
		this.result = result;
		this.param1 = param1;
		this.param2 = param2;
	}

	/**
	 * 提供几组测试参数
	 */
	@Parameters//指定它是一个测试化参数
	public static Collection<Object[]> set(){
		return Arrays.asList(
				new Object[][]{
					{10,5,5},
					{12,4,8},
					{13,6,7}
				}
				);
	}
	
	@Test
	public void test() {
		assertEquals(result, new Calculate().add(param1, param2));
	}

}
