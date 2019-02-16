package com.lanou.demos;

/**
 * 饿汉式
 * 
 * @author LiuXu
 * @time2018年8月6日下午2:00:43
 **/
public class SingleDemo3 {

	// 定义一个本类对象属性

	private static SingleDemo3 demo3 = new SingleDemo3();

	// 构造方法私有化
	private SingleDemo3() {

	}

	/**
	 * 提供返回本类实例的方法
	 * 
	 * @return
	 */
	public static SingleDemo3 getDemo3() {
		return demo3;
	}
}
