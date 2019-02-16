package com.lanou;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LiuXu
 * @time2018年7月6日下午3:41:44
 **/
public class Demo7 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 获取serrion对象
		HttpSession session = req.getSession(true);

		String name = (String) session.getAttribute("name");
		int age = (int) session.getAttribute("age");

		// 写入前端
		res.getWriter().println(name + "--" + age);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);

	}

}
