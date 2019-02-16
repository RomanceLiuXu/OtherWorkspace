package com.stu.mvc.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.stu.mvc.beans.Student;
import com.stu.mvc.service.stuService;

/**
 * 连接数据库和
 * 
 * @author LiuXu
 * @time2018年7月9日下午9:08:10
 **/
public class stuServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 添加头部信息
		res.addHeader("Access-Control-Allow-Origin", "*");
		res.setContentType("text/html;charset=utf-8");
		// 接收客户端传来的页码
		String page = req.getParameter("page");
		// 指定每页显示的数据条数
		int pnum = 3;
		// 实例化
		stuService service = new stuService();
         int p = Integer.parseInt(page);  
         System.out.println(p);		 
		List<Student> students = service.findStudents(p, pnum);
		//获取页码
		int n = service.getNum("student", 3);
		// 将list集合转为json传到前端
		JsonObject obj1 = new JsonObject();
		obj1.addProperty("code", 200);
		obj1.addProperty("msg", "请求成功");
		obj1.addProperty("pagenum", n);
		JsonArray arr = new JsonArray();
		for (int i = 0; i < students.size(); i++) {
			Student student = students.get(i);
			JsonObject obj2 = new JsonObject();
			obj2.addProperty("id", student.getId());
			obj2.addProperty("name", student.getName());
			obj2.addProperty("birth", student.getBirth());
			obj2.addProperty("sex", student.getSex());
			arr.add(obj2);
		}
		obj1.add("content", arr);

		res.getWriter().println(obj1.toString());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
