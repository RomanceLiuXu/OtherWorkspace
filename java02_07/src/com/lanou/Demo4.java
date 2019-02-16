package com.lanou;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LiuXu
 * @time2018年7月6日下午2:52:11
 **/
public class Demo4 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 参数：属性名和属性值
		// 创建两个cookie
		Cookie cookie = new Cookie("name", "lhl");
		Cookie cookie2 = new Cookie("age", "18");

		// 设置cookie的过期时间
		// cookie.setMaxAge(5);

		Cookie cookie3 = new Cookie("age", "18");
		// 添加cookie
		res.addCookie(cookie);
		res.addCookie(cookie2);

		// 跳转到另外一个servlet
		// res.sendRedirect("demo5");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
