package com.lanou;
/**
*
* @author LiuXu
* @time2018年6月5日下午3:36:24
**/
public class Demo3 {

	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		Demo3_1 d3 = new Demo3_1();
		d3.setObject1(obj1);
		d3.setObject2(obj2);
		Demo3_2 d4 = new Demo3_2();
		d4.setObject1(obj1);
		d4.setObject2(obj2);
		
		d3.start();
		d4.start();
		
	}
	
	
}
class Demo3_1 extends Thread{
	private Object object1;
	private Object object2;
	

	public Object getObject1() {
		return object1;
	}


	public void setObject1(Object object1) {
		this.object1 = object1;
	}


	public Object getObject2() {
		return object2;
	}


	public void setObject2(Object object2) {
		this.object2 = object2;
	}


	@Override
	public void run() {
		super.run();
		synchronized (object1) {
			System.out.println("我是线程1，正在执行任务...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("我是线程1，准备执行特殊任务...");
			synchronized (object2) {
				System.out.println("我是线程1，正在执行特殊任务...");
			}
			
		}
		
	}
	
}
class Demo3_2 extends Thread{
	private Object object1;
	private Object object2;
	

	public Object getObject1() {
		return object1;
	}


	public void setObject1(Object object1) {
		this.object1 = object1;
	}


	public Object getObject2() {
		return object2;
	}


	public void setObject2(Object object2) {
		this.object2 = object2;
	}


	@Override
	public void run() {
		super.run();
		synchronized (object2) {
			System.out.println("我是线程2，正在执行任务...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("我是线程2，准备执行特殊任务...");
			synchronized (object1) {
				System.out.println("我是线程2，正在执行特殊任务...");
			}
			
		}
		
	}
	
}