package com.match.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.match.service.FindPswServiceE;

/**
 * 忘记密码
 * 
 * @author LiuXu
 * @time2018年7月12日下午10:50:25
 **/
public class FindPswServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 获取用户的密保数字
		String answer = req.getParameter("answer");
		// 获取用户的账号
		String name = req.getParameter("code");
		// 连接service层
		FindPswServiceE pswServiceE = new FindPswServiceE();
		boolean is = pswServiceE.findPsw(name, answer);
		int flag = 0;
		if (is) {
			flag = 1;
		}
		res.sendRedirect("checkpsw?flag=" + flag);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
