package com.lanou;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LiuXu
 * @time2018年6月6日上午8:47:44
 **/
public class MyDemo {

	public static void main(String[] args) {
		// A a = new A();
		// my1 my1 = new my1();
		// my2 my2 = new my2();
		// my1.setA(a);
		// my2.setA(a);
		// my1.start();
		// my2.start();

		// for (int i = 1; i < 10; i++) {
		// for (int j = 1; j <= i; j++) {
		// System.out.print(j + "*" + i + "=" + (i * j)+"\t");
		// }
		// System.out.println();
		// }
		//
		// }

		List<? extends Number> lis1 = new ArrayList<>();
//		lis1.add(12);
		lis1.get(0);

		List<Number> lis2 = new ArrayList<>();
		lis2.add(12);

		List<? super Integer> lis3 = new ArrayList<>();
		lis3.add(13);
		Object object = lis3.get(0);

	}

	class my1 extends Thread {
		A a;

		public A getA() {
			return a;
		}

		public void setA(A a) {
			this.a = a;
		}

		@Override
		public void run() {
			synchronized (a) {
				super.run();
				a.m1();
			}
		}
	}

	class my2 extends Thread {
		A a;

		public A getA() {
			return a;
		}

		public void setA(A a) {
			this.a = a;
		}

		@Override
		public void run() {
			synchronized (a) {
				super.run();
				a.m2();
			}
		}
	}

class A {

	public void m1() {
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

	public void m2() {
		for (int i = 5; i > 0; i--) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}
}
}