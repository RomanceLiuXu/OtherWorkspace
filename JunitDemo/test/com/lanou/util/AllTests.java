package com.lanou.util;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
* 测试套件，同时运行多个测试类
* 测试套件中不能写任何方法
* @author LiuXu
* @time2018年9月29日下午3:17:05
**/
@RunWith(Suite.class)
@SuiteClasses({ CalculateTest.class, ParameterTest.class, TestCase.class })
public class AllTests {

}
