package com.lanou.work;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LiuXu
 * @time2018年7月5日下午3:25:04
 **/
public class LogInCheck extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		// 获取登录传输的账号和密码
		String code = req.getParameter("code");
		String psw = req.getParameter("psw");
//		前端向servlet中传输中文乱码的问题
		code = URLEncoder.encode(code, "ISO-8859-1");
		code = URLEncoder.encode(code, "UTF-8");
		// 进行验证
		if (code.equals("刘旭") && psw.equals("123456")) {
			// 登录成功--跳转到主界面
			resp.sendRedirect("home");

		} else {
			// 登录失败--跳转到登录界面
			resp.sendRedirect("login");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
