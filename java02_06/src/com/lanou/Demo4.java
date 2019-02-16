package com.lanou;

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
 * 编写接口
 * 
 * @author LiuXu
 * @time2018年7月5日下午4:35:04
 **/
public class Demo4 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 准备json串
		// 准备需要转换的对象
		List<StudentE> lists = new ArrayList<>();
		StudentE stu1 = new StudentE("啦啦", 18, "男");
		StudentE stu2 = new StudentE("尔尔", 12, "女");
		StudentE stu3 = new StudentE("三三", 13, "男");
		StudentE stu4 = new StudentE("六六", 14, "男");
		// 添加到集合中
		lists.add(stu1);
		lists.add(stu2);
		lists.add(stu3);
		lists.add(stu4);

		// 实例化公共类
		CommonE ce = new CommonE(200, "请求成功", lists);

		// 将ce转成json串

		JsonObject obj = new JsonObject();
		obj.addProperty("code", ce.getCode());
		obj.addProperty("msg", ce.getMsg());

		// 实例化jsqrr
		JsonArray arr = new JsonArray();
		List<StudentE> list = (List<StudentE>) ce.getContent();
		for (int i = 0; i < list.size(); i++) {
			JsonObject obj2 = new JsonObject();
			StudentE s = list.get(i);
			obj2.addProperty("name", s.getName());
			obj2.addProperty("age", s.getAge());
			obj2.addProperty("sex", s.getSex());
			arr.add(obj2);
		}

		obj.add("content", arr);

		String json = obj.toString();
		// System.out.println(json);
		// 设置编码格式
		res.setContentType("text/html;charset=utf-8");
		// 添加头部信息
		res.addHeader("Access-Control-Allow-Origin", "*");
		res.getWriter().println(json);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		this.doGet(req, res);
	}
}
