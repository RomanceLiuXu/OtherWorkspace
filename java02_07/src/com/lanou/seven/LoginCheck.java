package com.lanou.seven;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LiuXu
 * @time2018年7月7日上午11:46:47
 **/
public class LoginCheck extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 获取信息
		String enter = req.getParameter("enter");
		String code = req.getParameter("code");
		String psw = req.getParameter("psw");
		Cookie cookie1 = new Cookie("code", code);
		Cookie cookie2 = new Cookie("psw", psw);
		// 设置编码格式
		enter = new String(enter.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println(enter + code + psw);
		if (enter.equals("7天免登录")) {
			if (code.equals("liuxu") && psw.equals("123456")) {
				// 实例化
				// 设置cookie的保存时间--7天
				cookie1.setMaxAge(604800);
				cookie2.setMaxAge(604800);
				res.addCookie(cookie1);
				res.addCookie(cookie2);
				// 跳转
				res.sendRedirect("view");
			} else {

				res.sendRedirect("login");
			}
		} else if (enter.equals("登录")) {
			if (code.equals("liuxu") && psw.equals("123456")) {
				// 设置cookie的保存时间
				cookie1.setMaxAge(0);
				cookie2.setMaxAge(0);
				res.addCookie(cookie1);
				res.addCookie(cookie2);

				// 跳转
				res.sendRedirect("view?code=" + code);
			} else {
				res.sendRedirect("login");
			}
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	};
}
