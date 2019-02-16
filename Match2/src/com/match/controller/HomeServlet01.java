package com.match.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.match.beans.UserP;
import com.match.service.HomeServiceE01;

/**
 * @author lichenfei
 * @time 2018年7月14日下午8:32:37
 *
 *       一个查询登录会员的信息的接口：
 *
 */
public class HomeServlet01 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 设置编码格式：
		res.setContentType("text/html;charset=utf8");
        HttpSession session = req.getSession();
		// 接受前端传来的信息：
		String uid = req.getParameter("uid");
		// 数据类型转换：
		 int ui = Integer.parseInt(uid);
		// int ui = 4;
		// 实例化service层：
		HomeServiceE01 hs = new HomeServiceE01();
		// 调用方法：
		List<UserP> lists = hs.show(ui);
		
		if (lists!=null) {
			session.setAttribute("single-user", lists);
		}
//		// 转为json串：
//		JsonObject obj1 = new JsonObject();
//		JsonArray arr = new JsonArray();
//		// 遍历：
//		for (UserP us : lists) {
//			JsonObject obj2 = new JsonObject();
//			obj2.addProperty("uid", us.getUid());
//			obj2.addProperty("name", us.getName());
//			obj2.addProperty("sex", us.getSex());
//			obj2.addProperty("age", us.getAge());
//			JsonObject obj3 = new JsonObject();
//			obj3.addProperty("pname", us.getPicture().getPname());
//			obj3.addProperty("paddress", us.getPicture().getPaddress());
//			obj2.add("picture", obj3);
//			arr.add(obj2);
//
//		}
//		obj1.add("userp", arr);
//		System.out.println(obj1.toString());
//		// 获取pw对象：
//		PrintWriter pw = res.getWriter();
//		pw.println(obj1.toString());

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		this.doGet(req, resp);

	}

}
