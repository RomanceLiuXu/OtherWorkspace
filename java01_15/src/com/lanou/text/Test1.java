package com.lanou.text;

/**
 * 线程同步锁--锁属性
 * 
 * @author LiuXu
 * @time2018年6月4日下午4:39:26
 **/
public class Test1 extends Thread {
	String num;

	public Test1(String num) {
		super();
		this.num = num;
	}

	public Test1() {
		super();
	}

	@Override
	public void run() {
		super.run();
		// 加一个同步锁
		synchronized (num) {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				System.out.println(i);
			}
		}
	}

}
