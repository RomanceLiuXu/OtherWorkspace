package com.lanou;

/**
 * 线程
 * 
 * @author LiuXu
 * @time2018年6月4日下午3:11:55
 **/
public class test1 {
	// 进程：一个进程有独立的运行空间(内存地址)
	// 1.一个运行中的应用程序就是一个进程
	// 2.进程是有独立的地址空间的(内存)，并且该地址空间是可以扩充的，但是这个过程是由系统和JVM决定的

	// 线程：
	// 1.线程是轻量级的进程
	// 2.线程没有独立的地址空间
	// 3.线程必须要寄生在进程中
	// 4.一个进程中可以存在多个线程
	// 5.线程是系统中的最小调度单位

	// 线程的运行周期
	// 1.创建
	// 2.可运行(就绪)
	// 3.运行
	// 4.阻塞
	// 5.死亡

	// 注意：同一个线程不可以同时启动多次
	/*
	 * 主函数
	 */
	public static void main(String[] args) {

		// 实例化
		Demo1 demo1 = new Demo1("线程1");
		// 调用线程类中的start方法
		// 调用该方法后，线程属于可运行状态
		demo1.start();
		//
		Demo1 demo1_1 = new Demo1("线程2");
		demo1_1.start();

		// 实例化
		// Demo2 demo2 = new Demo2("Demo2线程1");
		// // 实例化一个Thread
		// Thread thread = new Thread(demo2);
		// thread.start();

		// 使用匿名内部类的方法
		Thread thread = new Thread(new Runnable() {

			@Override
			public void run() {
				Thread thread = Thread.currentThread();
				for (int i = 0; i < 5; i++) {
					System.out.println(thread.getName() + ":" + i);
				}

			}
		});
		thread.start();

		// 或者不用对象接收
		new Thread(new Runnable() {

			@Override
			public void run() {
				Thread thread = Thread.currentThread();
				for (int i = 0; i < 5; i++) {
					System.out.println(thread.getName() + ":" + i);
				}

			}
		}).start();
		;

		// Demo4 demo4 = new Demo4();
		// demo4.start();
	}
}
