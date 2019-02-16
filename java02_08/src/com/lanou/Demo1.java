package com.lanou;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LiuXu
 * @time2018年7月9日下午2:07:24
 **/
public class Demo1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 获取数据库中的数据显示到前端
		res.setContentType("text/html;charset=utf-8");
		// 添加头部信息(解决跨域问题)
		// res.addHeader("Access-Control-Allow-Origin", "*");
		Demo2 d2 = new Demo2();
		String result = d2.getData();
		PrintWriter pw = res.getWriter();
		pw.println(result);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
