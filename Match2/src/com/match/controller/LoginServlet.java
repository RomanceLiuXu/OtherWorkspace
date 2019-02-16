package com.match.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonObject;
import com.match.beans.User;
import com.match.service.LoginServiceE;

/**
 *
 * @author LiuXu
 * @time2018年7月11日下午7:04:29
 **/
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		HttpSession session = req.getSession();
		res.setContentType("text/html;charset=utf-8");
		// 获取登录数据
		String name = req.getParameter("code");
		String psw = req.getParameter("psw");
		PrintWriter pw = res.getWriter();
		// 连接service层
		LoginServiceE serviceE = new LoginServiceE();
		// 判断数据的有效性
		if (name != null && psw != null && name != "" && psw != "") {
			// 调用方法返回对应的用户对象
			User user = serviceE.singleUser(name, psw);
			if (user != null) {
				 String jsonStr = JSON.toJSONString(user);
				 System.out.println(jsonStr);
				 pw.println(jsonStr);
				// 将数据放在容器中
//				session.setAttribute("login-user", user);
//				// 发送到主页面
//				res.sendRedirect("jsp/login.jsp");
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
