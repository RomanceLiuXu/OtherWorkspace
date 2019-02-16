package com.match.hibernate;

import java.util.List;

import com.liuxu.beans.Picture;
import com.liuxu.beans.User;

/**
 *
 * @author LiuXu
 * @time2018年8月20日下午9:44:54
 **/
public class Test {

	public static void main(String[] args) {

		UserHibernate h = new UserHibernate();
		// // 登录验证
		User user = new User();
		user.setName("刘旭");
		user.setPsw("123456");
		user = h.login(user);
		System.out.println(user);

		// 注册验证
		// User user2 = new User("欢迎", 12, "男", "陕西西安", "1234", "1234");
		// Picture picture = new Picture("huan.png", "marry/huan.png", user2);
		// user2.setPicture(picture);
		// boolean register = h.register(user2);
		// System.out.println(register);

		// 同城匹配
		// List<User> sameCity = h.sameCity(user);
		// for (User user2 : sameCity) {
		// System.out.println(user2);
		// }

		// 异城匹配
		// List<User> notSameCity = h.notSameCity(user);
		// for (User user2 : notSameCity) {
		// System.out.println(user2);
		// }

		// 修改密码
		// boolean updatePsw = h.updatePsw(user, "liuxu123");
		// System.out.println(updatePsw);

		// 忘记密码
		User user2 = h.checkPsw("三三", "1234");
		System.out.println(user2);
		boolean is = h.updatePsw(user2, "12san");
		System.out.println(is);

	}

}
