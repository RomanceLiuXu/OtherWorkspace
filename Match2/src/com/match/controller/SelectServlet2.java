package com.match.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonObject;
import com.match.beans.UserP;
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
		
		HttpSession session = req.getSession();
		List<UserP> userPps = (List<UserP>)session.getAttribute("list2");
		// 获取用户的id
		int uid = userPps.get(0).getUid();
		// int uid = 1;
		// int age = 28;
		// String sex = "男";
		// String address = "陕西";
		// 获取用户的年龄
		int age = userPps.get(0).getAge();
		// // 获取用户的性别
		String sex = userPps.get(0).getSex();

		// 获取用户的地址
		String address1 = userPps.get(0).getAddress();
		String address = address1.substring(0, 2);
		// System.out.println(address);
		// 将信息传递给service层
		SelectService select = new SelectService();
		// 调dao层的方法
		List<UserPp> list = select.selectMethod2(uid, age, sex, address);
		session.setAttribute("list4", list);
		res.sendRedirect("jsp/select2.jsp");
//		// 将map转为json串
//		String json = JSON.toJSONString(list, true);
//		// 获取pw对象
//		PrintWriter pw = res.getWriter();
//		// pw.write(json);
//		// 将json串写入前端
//		pw.println(json.toString());
//		System.out.println(json.toString());

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.doGet(req, res);
	}
}
