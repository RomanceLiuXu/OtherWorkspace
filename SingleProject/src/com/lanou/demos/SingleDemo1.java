
package com.lanou.demos;

/**
 * 懒汉式 -- 线程不安全
 * 
 * @author LiuXu
 * @time2018年8月6日上午11:39:46
 **/
public class SingleDemo1 {

	private static SingleDemo1 demo1;

	/**
	 * 将构造方法私有化
	 */
	private SingleDemo1() {

	}

	/**
	 * 对外提供一个访问唯一对象的方法
	 * 
	 * @return
	 */
	public static SingleDemo1 getDemo1() {
		// 判断demo1对象是否存在
		if (demo1 == null) {
			// 不存在则创建
			demo1 = new SingleDemo1();
		}

		return demo1;
	}
}
