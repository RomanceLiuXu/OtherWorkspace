package com.liuxu.day1;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 *
 * @author LiuXu
 * @time2018年8月14日下午10:25:08
 **/
public class Test {

	public static void main(String[] args) {

		Facher f = new Facher();
		son son = new son();
		HashMap map = new HashMap<>();
		// Map map = new HashMap<>();
		f.m1(map);
		son.m1(map);
		
		Runnable runnable  = new Runnable() {
			
			@Override
			public void run() {
			System.out.print("ss");
				
			}
		};

		 Thread thread = new Thread(runnable);
		 thread.start();
		 System.out.print("far");
		 Test2.test();
		 
		 String string = UUID.randomUUID().toString();
		 System.out.println(string);
	}

}

class Test2{
	public static void add(byte b) {
		b =b++;
		
	}
	public static void test() {
		Byte a = 127;
		Byte b = 127;
		add(++a);
		System.out.println("a："+a);
		add(b);
		System.out.println("b："+b);
	}
}

class Facher {
	public void m1(HashMap map) {
		System.out.println("父类执行方法");
	}
}

class son extends Facher {
	
	public void m1(Map map) {
		System.out.println("子类执行方法");

	}

}