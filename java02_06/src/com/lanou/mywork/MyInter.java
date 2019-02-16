package com.lanou.mywork;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 *
 * @author LiuXu
 * @time2018年7月5日下午7:14:13
 **/
public class MyInter extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 准备对象集合
		List<StudentE> lists = new ArrayList<>();

		// 实例化
		StudentE stu1 = new StudentE("大王", 18, 85);
		StudentE stu2 = new StudentE("小王", 35, 85);
		StudentE stu3 = new StudentE("周梦", 20, 90);
		StudentE stu4 = new StudentE("小花", 18, 90);
		StudentE stu5 = new StudentE("画画", 25, 60);

		// 添加到集合中
		lists.add(stu1);
		lists.add(stu2);
		lists.add(stu3);
		lists.add(stu4);
		lists.add(stu5);

		// 实例化
		Common cm = new Common(200, "成功", lists);

		// 转为json数据
		JsonObject obj = new JsonObject();

		obj.addProperty("code", cm.getCode());
		obj.addProperty("msg", cm.getMsg());

		List<StudentE> list = (List<StudentE>) cm.getData();

		JsonArray arr = new JsonArray();
		for (int i = 0; i < list.size(); i++) {
			StudentE s = list.get(i);
			JsonObject obj1 = new JsonObject();
			obj1.addProperty("name", s.getName());
			obj1.addProperty("age", s.getAge());
			obj1.addProperty("score", s.getScore());
			arr.add(obj1);
		}

		obj.add("data", arr);

		// 准备向前端发送的数据
		String jsonStr = obj.toString();

		// 设置编码格式
		res.setContentType("text/html;charset=utf-8");
		// 添加头部信息
		res.addHeader("Access-Control-Allow-Origin", "*");

		// 返回数据
		res.getWriter().println(jsonStr);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
