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
 * @time2018年7月6日下午2:58:04
 **/
public class Demo5 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 设置编码格式
		res.setContentType("text/html;charset=utf-8");
		Cookie[] cookies = req.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			// 获取对象
			Cookie cookie = cookies[i];
			String key = cookie.getName();
			String value = cookie.getValue();
			res.getWriter().println(key + ":" + value);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		this.doGet(req, resp);
	}

}
