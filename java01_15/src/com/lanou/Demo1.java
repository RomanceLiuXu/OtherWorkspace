package com.lanou;

/**
 * 线程的实现方式一 ----继承
 * 
 * @author LiuXu
 * @time2018年6月4日下午3:44:39
 **/
public class Demo1 extends Thread {

	private String name1;

	public Demo1() {
		super();
	}

	public Demo1(String name1) {
		super();
		this.name1 = name1;
	}
	/*
	 * 复写父类的run方法
	 */
	@Override
	public void run() {
		super.run();
		// 获取线程对象
		Thread thread = Thread.currentThread();
		// thread.setName("自定义线程名");
		for (int i = 0; i < 100; i++) {
			// 获取线程的名字---thread.getName()
			// 打印线程名和变量
			
			System.out.println(thread.getName() + i);
		}
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}


}
