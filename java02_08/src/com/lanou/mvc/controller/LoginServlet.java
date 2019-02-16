package com.lanou.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lanou.mvc.beans.User;
import com.lanou.service.LoginService;

/**
 *
 * @author LiuXu
 * @time2018年7月9日下午4:58:55
 **/
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 接收用户输入的内容
		String code = req.getParameter("code");
		String psw = req.getParameter("psw");

		// 实例化bean对象
		User user = new User();
		user.setCode(code);
		user.setPsw(psw);
		// 将user传递到service层
		LoginService service = new LoginService();
		// 调方法
		boolean boo = service.logincheck(user);

		// 返回前端
		if (boo) {
			res.sendRedirect("res.html?flag=success");
		} else {
			res.sendRedirect("res.html?flag=error");
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	};
}
