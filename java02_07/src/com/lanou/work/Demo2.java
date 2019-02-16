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
 * @time2018年7月6日下午9:23:22
 **/
public class Demo2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 设置编码格式
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		// 获取对象
		HttpSession session = req.getSession(true);
		String str = (String) session.getAttribute("enter");
		if (str != null) {
			if (str.equals("登录")) {
				String code = req.getParameter("code");
				pw.println("欢迎你," + code);
				session.removeAttribute("enter");
			} else if (str.equals("保存登录")) {
				String code = (String) session.getAttribute("code");
				pw.println("欢迎你," + code);
			} else {
				res.sendRedirect("demo1");
			}
		} else {
			pw.println("非法登录");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
