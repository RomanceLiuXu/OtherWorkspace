package com.match.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonObject;
import com.match.beans.UserPp;
import com.match.service.SelectService;

/**
 *
 * @author xxc
 * @time 2018年7月11日下午8:02:51
 **/
public class SelectServlet2 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 设置编码格式
		res.setContentType("text/html;charset=UTF8");
		// 解决跨域的问题：
		res.addHeader("Access-Control-Allow-Origin", "*");
		// 获取用户的id
		int uid = Integer.parseInt(req.getParameter("uid"));
		// int uid = 1;
		// int age = 28;
		// String sex = "男";
		// String address = "陕西";
		// 获取用户的年龄
		int age = Integer.parseInt(req.getParameter("age"));
		// // 获取用户的性别
		String sex = req.getParameter("sex");

		// 获取用户的地址
		String address1 = req.getParameter("address");
		String address = address1.substring(0, 1);
		// System.out.println(address);
		// 将信息传递给service层
		SelectService select = new SelectService();
		// 调dao层的方法
		List<UserPp> list = select.selectMethod2(uid, age, sex, address);
		// 将map转为json串
		String json = JSON.toJSONString(list, true);
		// 获取pw对象
		PrintWriter pw = res.getWriter();
		// pw.write(json);
		// 将json串写入前端
		pw.println(json.toString());
		System.out.println(json.toString());

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.doGet(req, res);
	}
}
