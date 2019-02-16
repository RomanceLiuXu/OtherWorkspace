package com.lanou.text;

/**
 * 匿名内部类锁属性、方法和类
 * @author LiuXu
 * @time2018年6月4日下午4:51:53
 **/
public class Demo3 {

	private String str;

	public Demo3() {
		super();
	}

	public Demo3(String str) {
		super();
		this.str = str;
	}

	/*
	 * 锁方法
	 */
	public synchronized void method2() {

		Thread thread = Thread.currentThread();
		for (int i = 0; i < 5; i++) {

			System.out.println(thread.getName() + ":" + i);

		}
	}

	/*
	 * 锁类
	 */
	public void method3() {
		Thread thread = Thread.currentThread();
		synchronized (Test3.class) {
			for (int i = 0; i < 5; i++) {
				System.out.println(thread.getName() + ":" + i);

			}

		}
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	/*
	 * 锁属性
	 */
	public void method1() {
		synchronized (str) {
			Thread thread = Thread.currentThread();
			for (int i = 0; i < 3; i++) {
				System.out.println(thread.getName() + ":" + i);
			}
		}
	}

}
