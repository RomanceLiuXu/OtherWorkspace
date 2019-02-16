package com.lanou.text;

/**
 * 同步锁--锁类
 * 
 * @author LiuXu
 * @time2018年6月4日下午5:13:19
 **/
public class Test3 extends Thread {

	@Override
	public void run() {

		super.run();
		Thread thread = Thread.currentThread();
		//.class 获取Test3这个类
		synchronized (Test3.class) {
			for (int i = 0; i < 4; i++) {
				System.out.println(thread.getName() + ":" + i);
			}
		}
	}
}
