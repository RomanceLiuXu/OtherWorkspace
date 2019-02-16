package com.lanou;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LiuXu
 * @time2018年7月6日下午4:54:10
 **/
public class Test extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		Cookie[] cookies = req.getCookies();
		PrintWriter pw = res.getWriter();
		// 遍历
		for (int i = 0; i < cookies.length; i++) {
			pw.println(cookies[i].getName() + ":" + cookies[i].getValue());
		}
//		获取session内容
		HttpSession session = req.getSession();
		String name = (String) session.getAttribute("name");
		int age = (int) session.getAttribute("age");
		pw.println(name + ":" + age);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
