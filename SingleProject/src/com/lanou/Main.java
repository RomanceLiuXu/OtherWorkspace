package com.lanou;

import com.lanou.demos.SingleDemo1;
import com.lanou.demos.SingleDemo3;

/**
 *
 * @author LiuXu
 * @time2018年8月6日上午11:25:06
 **/
public class Main {

	public static void main(String[] args) {
		//
		// Car car1 = new Car();
		// Car car2 = new Car();
		//
		// System.out.println(car1 + "--" + car2);

		// 通过类名直接获取单例对象--懒汉
		SingleDemo1 demo1 = SingleDemo1.getDemo1();
		System.out.println(demo1);

		// 通过类名直接获取单例对象--饿汉
		SingleDemo3 demo3 = SingleDemo3.getDemo3();
		System.out.println(demo3);

		final Car car = new Car("kk", 2000);
		car.setPrice(200);
		System.out.println(car.getPrice());
		
		
	String s = "a" +"b" +"c";
	String s1 = "abc";
	System.out.println(s==s1);
	}

}
