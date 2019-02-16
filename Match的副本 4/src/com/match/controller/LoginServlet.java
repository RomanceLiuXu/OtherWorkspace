package com.match.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		res.setContentType("text/html;charset=utf-8");
		// 获取登录数据
		String name = req.getParameter("code");
		String psw = req.getParameter("psw");
		// 是否记住密码
		// String remember = req.getParameter("remember");
		// System.out.println(name + "--" + psw + "--" + remember);
		PrintWriter pw = res.getWriter();
		// 连接service层
		LoginServiceE serviceE = new LoginServiceE();
		// 判断数据的有效性
		if (name != null && psw != null && name != "" && psw != "") {
			// 调用方法返回对应的用户对象
			User user = serviceE.singleUser(name, psw);
			if (user != null) {
				// // 是否记住密码
				// if (remember!=null) {
				// Cookie cookie = new Cookie("pass", "ok");
				// cookie.setMaxAge(3600 * 24 * 7);
				// res.addCookie(cookie);
				// System.out.println("我是cookie");
				// }
				String jsonStr = JSON.toJSONString(user);
				System.out.println(jsonStr);
				pw.println(jsonStr);
			}
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
