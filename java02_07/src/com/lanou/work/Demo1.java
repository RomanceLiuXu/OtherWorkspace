package com.lanou.work;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LiuXu
 * @time2018年7月6日下午8:58:21
 **/
public class Demo1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 设置编码格式
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		HttpSession session = req.getSession(true);
		// 获取传来的值
		String code = req.getParameter("code");
		String psw = req.getParameter("psw");
		String enter = req.getParameter("enter");
		System.out.println(enter);
		enter = new String(enter.getBytes("ISO-8859-1"), "UTF-8");
		System.out.println("--" + enter);
		session.setAttribute("enter", enter);
		if (enter.equals("登录")) {
			if (code.equals("liuxu") && psw.equals("123456")) {
				res.sendRedirect("wdemo2?code=" + code);
			} else {
				res.sendRedirect("work");
			}
		} else if (enter.equals("保存登录")) {
			if (code.equals("liuxu") && psw.equals("123456")) {
				// 获取session
				// 设置
				session.setAttribute("code", code);
				session.setAttribute("psw", psw);
				session.setMaxInactiveInterval(3600 * 24 * 5);
				// 跳转到登录成功界面
				res.sendRedirect("wdemo2");
			} else {
				// 调回登录页面
				res.sendRedirect("work");
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
