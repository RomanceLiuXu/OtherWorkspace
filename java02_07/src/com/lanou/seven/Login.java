package com.lanou.seven;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LiuXu
 * @time2018年7月7日上午11:46:13
 **/
public class Login extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 设置编码格式
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		pw.println("<div>");
		pw.println("<form action='loginc' method='post'>");
		pw.println("<input type='text' name='code' /> <br />");
		pw.println("<input type='text' name='psw'  /> <br />");
		pw.println("<input type='submit' name = 'enter' value='登录' />");
		pw.println("<input type='submit' name = 'enter' value='7天免登录' />");
		pw.println("</form>");
		pw.println("</div>");

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	};

}
