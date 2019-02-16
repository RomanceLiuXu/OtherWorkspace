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
 * @time2018年7月6日上午9:10:24
 **/
public class Demo2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 设置编码格式
		res.setContentType("text/html;charset=utf-8");
		// // String name = req.getParameter("name");
		 String msg = req.getParameter("msg");
		// // 写入对象
		 PrintWriter pw = res.getWriter();
		 pw.println("<div>" + msg + ",欢迎你</div>");
		// // 接收对象
		// Person person = (Person) req.getAttribute("person");
		// PrintWriter pw = res.getWriter();
		// pw.println("<div>" + person.getName() + ":" + person.getAge() +
		// "</div>");

//		String name = req.getParameter("name");
//		String psw = req.getParameter("psw");
//		// 写入
//		PrintWriter pw = res.getWriter();
//		pw.println("<div>" + name + "--" + psw + "</div>");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
