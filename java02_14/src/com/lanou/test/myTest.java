package com.lanou.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

/**
 * Servlet implementation class myTest
 */
@WebServlet("/myTest")
public class myTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		// 为标签的name属性 name=code&pname=name.value
		String name = req.getParameter("name");
		// name输入框对应的值
		String code = req.getParameter("param");
		System.out.println(name + ":" + code);
		PrintWriter writer = resp.getWriter();
		JsonObject object = new JsonObject();
		String info = "";
		String status = "";
		if (!code.equals("liuxu")) {
			info = "用户名可用";
			status = "y";
		} else {
			info = "用户名已存在";
			status = "n";
		}
		object.addProperty("info", info);
		object.addProperty("status", status);
		writer.print(object.toString());

	}
	//
	// @Override
	// protected void doGet(HttpServletRequest req, HttpServletResponse resp)
	// throws ServletException, IOException {
	//
	// }
	//
	// @Override
	// protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	// throws ServletException, IOException {
	// this.doGet(req, resp);
	// }

}
