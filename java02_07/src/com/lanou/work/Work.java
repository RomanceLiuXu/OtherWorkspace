package com.lanou.work;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LiuXu
 * @time2018年7月6日下午8:47:54
 **/
public class Work extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 设置编码格式
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.println("<div>");
		pw.println("<form action='wdemo' method='post'>");
		pw.println("<input type='text' name='code' /> <br />");
		pw.println("<input type='text' name='psw'  /> <br />");
		pw.println("<input type='submit' name = 'enter' value='登录' />");
		pw.println("<input type='submit' name = 'enter' value='保存登录' />");
		pw.println("</form>");
		pw.println("</div>");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
