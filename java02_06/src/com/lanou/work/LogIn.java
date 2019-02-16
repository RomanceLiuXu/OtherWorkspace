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
 * @time2018年7月5日下午3:00:33
 **/
public class LogIn extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
//		获取pw
		PrintWriter pw = resp.getWriter();
//		编写前端页面
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		
		pw.println("<body>");
		pw.println("<form action='logincheck' method='get'>");
		pw.println("<span>用户名:</span>");
		pw.println("<input type='text' name='code' /><br />");
		pw.println("<span>密码:</span>");
		pw.println("<input type='text' name='psw' /><br />");
		pw.println("<input type='submit' value='登录' />");
		pw.println("</form>");
		
		pw.println("</body>");
		
		pw.println("</html>");
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		调用本类的doget方法
		this.doGet(req, resp);
		
	}
}
