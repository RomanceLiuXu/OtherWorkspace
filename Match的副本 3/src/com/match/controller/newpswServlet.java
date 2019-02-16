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
import com.match.service.newpswserviceE;

/**
 *
 * @author keb
 * @tim2018年7月14日上午8:57:36
 **/
public class newpswServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//获取前端发来的值
		String newpsw = req.getParameter("newpsw");
		String usename = req.getParameter("name");
		//System.out.println(newpsw+usename+"789464896");
		//实例化实体类并设置属性
		User user = new User();
		user.setPsw(newpsw);
		user.setName(usename);
		//调取service层方法
		newpswserviceE newpswservice = new  newpswserviceE();
		boolean boo = newpswservice.newpswMethod(user);
		//String flag = JSON.toJSONString(boo);
		//System.out.println(flag);
		//实例化写入对象
		//req.setAttribute("flag", boo);
		//PrintWriter pw = resp.getWriter();
		//pw.println(flag);
		int flag = 0;
		if (boo) {
			flag = 1;
		}
		//res.sendRedirect("checkpsw?flag=" + flag);
		PrintWriter pw = resp.getWriter();
		JsonObject obj1 = new JsonObject();
		obj1.addProperty("flag", flag);
		 //写入前端
		 pw.println(obj1.toString());
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
