package com.lanou.javaobserver;

import java.util.Observer;

/**
 *
 * @author LiuXu
 * @time2018年8月7日下午2:44:33
 **/
public class Test {

	public static void main(String[] args) {
		Anchor anchor = new Anchor();

		Observer user1 = new User();
		Observer user2 = new User1();

		anchor.addObserver(user1);
		anchor.addObserver(user2);

		anchor.setData("我上线了，快来围观");

	}
}
