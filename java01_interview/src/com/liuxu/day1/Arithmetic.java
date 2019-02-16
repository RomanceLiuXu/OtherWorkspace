package com.liuxu.day1;

/**
 * 基础算法题
 * 
 * @author LiuXu
 * @time2018年8月13日下午9:52:31
 **/
public class Arithmetic {

	public static void main(String[] args) {

		// 枚举的使用
		Week w = Week.Day1;
		switch (w) {
		case Day1:

			break;
		case Day2:
			break;
		default:
			break;
		}

		// // 1.打印水仙花数
		// for (int i = 100; i < 1000; i++) {
		// int b1, b2, b3;
		// // 百位
		// b1 = i / 100;
		// // 十位
		// b2 = i % 100 / 10;
		// // 个位
		// b3 = i % 100 % 10;
		// if (b1 * b1 * b1 + b2 * b2 * b2 + b3 * b3 * b3 == i) {
		// System.out.println(i);
		// }
		//
		// }

		// 猴子吃桃
		int x = 1;
		for (int i = 2; i <= 10; i++) {
			x = (x + 1) * 2;
		}
		System.out.println(x);

		// 猴子仍桃

		// 年龄
		int age = 10;
		for (int i = 2; i <= 5; i++) {
			age = age + 2;
		}
		System.out.println(age);

	}

}
