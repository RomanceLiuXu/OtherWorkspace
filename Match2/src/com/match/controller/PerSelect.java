package com.match.controller;



import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonObject;
import com.match.beans.Picture;
import com.match.beans.User;
import com.match.service.SelectService;


/**
 *
 * @author xxc
 * @time 2018年7月13日上午10:31:29
 **/
public class PerSelect extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 设置编码格式
		res.setContentType("text/html;charset=UTF8");
		HttpSession session = req.getSession();
		// 解决跨域的问题：
		//res.addHeader("Access-Control-Allow-Origin", "*");
		// 获取用户的id
		String id = req.getParameter("uid");
		// 将id转为int类型的数据
		int uid = Integer.parseInt(id);
		// 转为sevice层
		// 实例化SelectService
		SelectService select = new SelectService();
		// 调方法
//		Map<Picture, User> map = select.perMethod(uid);
//		
//		session.setAttribute("maps", map);
//	
		//req.getRequestDispatcher("jsp/person.jsp").forward(req, res);
//		// 将map转为json串
//		JsonObject obj = new JsonObject();
//		for (Picture user : map.keySet()) {
//			JsonObject obj1 = new JsonObject();
//			obj1.addProperty("uid", user.getUid());
//			obj1.addProperty("address", user.getAddress());
//			obj1.addProperty("name", user.getName());
//			obj1.addProperty("sex", user.getSex());
//			obj1.addProperty("age", user.getAge());
//			obj1.addProperty("psw", user.getPsw());
//			obj.add("user", obj1);
//			JsonObject obj2 = new JsonObject();
//			obj2.addProperty("pname", map.get(user).getPname());
//			obj2.addProperty("paddress", map.get(user).getPaddress());
//			obj.add("picture", obj2);
//		}
//		
//		// 获取pw对象
//		PrintWriter pw = res.getWriter();
//		// 写入前端
//		pw.println(obj.toString());
//		res.sendRedirect("jsp/person.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.doGet(req, res);
	}
}
