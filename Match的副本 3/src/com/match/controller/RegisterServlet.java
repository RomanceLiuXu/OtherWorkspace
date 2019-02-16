package com.match.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonObject;
import com.match.beans.User;
import com.match.dao.RegisterDaoE;
import com.match.service.RegisterServiceE;

/**
 *
 * @author keb
 * @tim2018年7月12日下午3:36:15
 **/
public class RegisterServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 设置编码格式
		resp.setContentType("text/html;charset=utf-8");
		// 获取请求的数据
		// int newid =Integer.valueOf (req.getParameter("uid"));
		// System.out.println(newid);
		String newname = req.getParameter("name");
		int newage = Integer.valueOf(req.getParameter("age"));
		String newsex = req.getParameter("sex");
		String newaddress = req.getParameter("address");
		String newpsw = req.getParameter("psw");
		String newsnwer = req.getParameter("snswer");
		// 实例化user类,并赋值
		User user = new User(newname, newage, newsex, newaddress, newpsw, newsnwer);
		// 调用service的方法
		RegisterServiceE regservicee = new RegisterServiceE();
		// 掉方法
		int n = regservicee.addMethod(user);
		// 实例化写入对象
		PrintWriter pw = resp.getWriter();
		// // 定义标识向前端传送信息
		// boolean flag = true;
		// // 如果为-1则证明传送失败,传送false,否则传送true;
		// if (n == -1) {
		// flag = false;
		// } else {
		// // 将获取的ID找出来
		// System.out.println("获取的ID为:" + n);
		// // req.setAttribute("uid", n);
		// // resp.sendRedirect("fileup?uid=" + n);
		//
		// }
		JsonObject obj1 = new JsonObject();
		obj1.addProperty("flag", n);

		// 写入前端
		pw.println(obj1.toString());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
