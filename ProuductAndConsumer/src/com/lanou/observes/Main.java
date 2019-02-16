package com.lanou.observes;

/**
 *
 * @author LiuXu
 * @time2018年8月7日下午2:27:15
 **/
public class Main {

	public static void main(String[] args) {

		// 获取对象
		Anchor anchor = Anchor.getAnchor();
         
		Observer user1 = new User1();
		Observer user2 = new User2();

		anchor.addSubscribe(user1);
		anchor.addSubscribe(user2);
		// 通知观察者
		anchor.notice();

	}
}
