package com.lanou.demos;

/**
 * 懒汉式--线程安全的做法
 * @author LiuXu
 * @time2018年8月6日上午11:54:08
 **/
public class SingleDemo2 {

	private static SingleDemo2 demo2;

	private SingleDemo2() {

	}

	/**
	 * 为了保证线程安全，通过锁方法实现
	 * @return
	 */
	public static synchronized SingleDemo2 getDemo2() {
		if (demo2 == null) {
			demo2 = new SingleDemo2();
		}

		return demo2;
	}
}
