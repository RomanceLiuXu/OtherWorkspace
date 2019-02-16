package com.lanou;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
*
* @author LiuXu
* @time2018年7月6日上午9:58:40
**/
public class Demo3 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//	    设置编码格式
		res.setContentType("text/html;charset=utf-8");
		
		res.sendRedirect("demo2?name=liuxu&psw=123456");
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
