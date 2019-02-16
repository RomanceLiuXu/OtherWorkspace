package com.lanou.seven;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LiuXu
 * @time2018年7月7日上午11:47:48
 **/
public class MainView extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 设置编码格式
		// 设置编码格式
		res.setContentType("text/html;charset=utf-8");
		Cookie[] cookies = req.getCookies();
		PrintWriter pw = res.getWriter();
		if (cookies != null) {
			System.out.println(cookies[0].getValue() + "--" + cookies[1].getValue());
			if (cookies[0].getValue().equals("liuxu") && cookies[1].getValue().equals("123456")) {
				pw.println("欢迎你," + cookies[0].getValue());
			}
		} else {
			String str = req.getParameter("code");
			if (str != null) {
				pw.println("欢迎你," + str);
			} else {
				res.sendRedirect("login");
			}

		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	};
}
