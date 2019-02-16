package com.lanou.text;

/**
 * 同步锁-- 锁方法
 * 
 * @author LiuXu
 * @time2018年6月4日下午5:00:07
 **/
public class Test2 extends Thread {

	public static synchronized void test1() {
		Thread thread = Thread.currentThread();
		for (int i = 0; i < 5; i++) {
			System.out.println(thread.getName() + ":" + i);
		}
	}

	@Override
	public void run() {

		super.run();
		test1();
	}

}
