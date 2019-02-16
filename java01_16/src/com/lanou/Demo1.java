package com.lanou;

import java.util.ArrayList;
import java.util.List;

/**
 * wait和notify和notifyAll
 * 
 * @author LiuXu
 * @time2018年6月5日上午11:24:09
 **/
public class Demo1 {

	// wait:
	// 如果某条线程在同步锁中调用了wait方法，表示该线程阻塞，让同步锁同一对象的其他线程先执行
	// notify:
	// 通知同一个同步锁中的wait线程可以继续执行了，如果在同一个同步锁下，有多个wait,notify只能随机解开一个wait
	// notifyAll:
	// 通知同一个同步锁下所有的wait可以接着执行了

	/*
	 * 主函数
	 */
	public static void main(String[] args) {
		// System.out.println(1+1);
		Object obj = new Object();
		Demo1_1 d1 = new Demo1_1(obj);
		Demo1_2 d2 = new Demo1_2(obj);
		Demo1_3 d3 = new Demo1_3(obj);
		d1.start();
		d3.start();
		d2.start();
        
		
		
	}

}

/**
 * 等待线程
 * 
 * @author xalo
 *
 */
class Demo1_1 extends Thread {
	private Object Object;

	public Demo1_1() {
		super();
	}

	public Demo1_1(java.lang.Object object) {
		super();
		Object = object;
	}

	public Object getObject() {
		return Object;
	}

	public void setObject(Object object) {
		Object = object;
	}

	@Override
	public void run() {
		super.run();
		synchronized (Object) {
			System.out.println("我是等待线程1，正在执行任务...");
			try {
				System.out.println("我是等待线程1，正在等待...");
				Object.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("我是等待线程1，继续执行任务...任务执行完毕");
		}
	}
}

/**
 * 唤醒线程
 * 
 * @author xalo
 *
 */
class Demo1_2 extends Thread {
	private Object object;

	public Demo1_2() {
		super();
	}

	public Demo1_2(Object object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		super.run();
		synchronized (object) {
			System.out.println("我是唤醒线程，正在执行任务");
			// object.notify();
			// 唤醒等待中的线程
			System.out.println("我是唤醒线程，执行任务完毕");
			object.notifyAll();
		}
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
}

class Demo1_3 extends Thread {
	private Object object;

	public Demo1_3() {
		super();
	}

	public Demo1_3(Object object) {
		super();
		this.object = object;
	}

	@Override
	public void run() {
		super.run();
		synchronized (object) {
			System.out.println("我是等待线程2，正在执行任务...");
			try {
				System.out.println("我是等待线程2，正在等待...");
				object.wait(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("我是等待线程2，继续执行任务...任务执行完毕");
		}
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
}
