package com.match.controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.match.beans.UserP;
import com.match.service.HomeServiceE;


/**
 * @author lichenfei
 * @time 2018年7月13日下午4:02:45
 *
 *
 *
 */
public class HomeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 设置编码格式：
		res.setContentType("text/html;charset=utf8");

		// 接受前端传来的信息：
		String sex = req.getParameter("sex");
		// String sex = "女";
//		 sex = URLEncoder.encode(sex, "ISO-8859-1");//解码
//		 sex = URLEncoder.encode(sex, "UTF-8");//编码
		// 实例化service层对象：
		HomeServiceE ho = new HomeServiceE();
		// 调用service层的方法：
		List<UserP> list = ho.findAll(sex);

		// 将对象转为json串：
		// 实例化一个：JsonObject
		JsonObject obj1 = new JsonObject();
		// 添加一个code：
		obj1.addProperty("code", 200);
		// 实例化一个JsonArray对象：
		JsonArray arr1 = new JsonArray();
		// System.out.println(list.toString());
		// 遍历集合：
		for (int i = 0; i < list.size(); i++) {
			// 实例化一个jsonobject
			JsonObject obj2 = new JsonObject();
			obj2.addProperty("name", list.get(i).getName());
			obj2.addProperty("age", list.get(i).getAge());
			obj2.addProperty("uid", list.get(i).getUid());
			obj2.addProperty("address", list.get(i).getAddress());
			obj2.addProperty("answer", list.get(i).getAnswer());
			obj2.addProperty("psw", list.get(i).getPsw());
			obj2.addProperty("sex", list.get(i).getSex());
			// 实例化一个jsonobject
			JsonObject obj3 = new JsonObject();
			// 获取UserP对象：
			UserP us = list.get(i);

			obj3.addProperty("pname", us.getPicture().getPname());
			obj3.addProperty("paddress", us.getPicture().getPaddress());
			obj3.addProperty("pid", us.getPicture().getPid());
			obj3.addProperty("uid", us.getPicture().getUid());
			obj2.add("picture", obj3);
			arr1.add(obj2);
		}
		// 添加到外层：
		obj1.add("con", arr1);
		// 将对象转换为json串：
		// 实例化一个pw对象：
		System.out.println(obj1.toString());
		PrintWriter pw = res.getWriter();
		pw.println(obj1.toString());
	

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		this.doGet(req, resp);
	}

}
