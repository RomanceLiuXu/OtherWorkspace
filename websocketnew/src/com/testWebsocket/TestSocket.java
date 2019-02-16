package com.testWebsocket;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TestSocket
 */
public class TestSocket extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置解码的编码方式
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		String psw = request.getParameter("psw");
		//这里只是简单模拟登陆
		if (username!=null&&psw!=null&&!username.equals("")&&!psw.equals("")) {
			System.out.println(username+psw);
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			response.sendRedirect("chat.jsp");//重定向
		}else{
			response.sendRedirect("login.jsp");
		}
	}

}
