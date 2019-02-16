package com.lanou;

/**
 * 上厕所类
 * 
 * @author LiuXu
 * @time2018年6月5日下午2:53:00
 **/
public class Demo2 {

	/*
	 * 主函数
	 */
	public static void main(String[] args) {
		Object obj = new Object();
		Person1 p1 = new Person1();
		p1.setObject(obj);
		Person2 p2 = new Person2();
		p2.setObject(obj);
		Person3 p3 = new Person3();
		p3.setObject(obj);

		p1.start();
		p3.start();
		p2.start();

	}

}

/**
 * 青年人
 * 
 * @author xalo
 *
 */
class Person1 extends Thread {
	private Object object;

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	public void run() {
		super.run();
		synchronized (object) {
			System.out.println("青年人正在进入厕所");
			System.out.println("青年人让出厕所");
			try {
				object.wait(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("青年人上完厕所");
		}

	}

}

/**
 * 中年人
 * 
 * @author xalo
 *
 */
class Person3 extends Thread {
	private Object object;

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	public void run() {
		super.run();
		synchronized (object) {
			System.out.println("中年人正在进入厕所");
			System.out.println("中年人让出厕所");
			try {
				object.wait(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("中年人上完厕所");
		}

	}

}

/**
 * 老年人
 * 
 * @author xalo
 *
 */
class Person2 extends Thread {
	private Object object;

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	public void run() {
		super.run();
		synchronized (object) {

			System.out.println("老年人正在上厕所");
			System.out.println("老年人上完厕所");
			object.notifyAll();

		}

	}

}
