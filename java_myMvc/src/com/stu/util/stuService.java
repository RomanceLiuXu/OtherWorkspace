package com.stu.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

/**
 *
 * @author LiuXu
 * @time2018年7月9日下午10:22:40
 **/
public class stuService extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		// 获取list集合并解析为JSON字符串传送给前端
		stuWork stuWork = new stuWork();
		List<Student> students = stuWork.selectStus();
		// 解析为json对象
		String result = JSON.toJSONString(students);
		System.out.println(result);
		pw.println(result);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
