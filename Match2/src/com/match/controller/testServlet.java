package com.match.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
*
* @author LiuXu
* @time2018年7月21日上午10:07:11
**/
public class testServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	      Cookie[] cookies = req.getCookies();
	      System.out.println(cookies.length);
	      for (Cookie cookie : cookies) {
			System.out.println(cookie.getName()+cookie.getValue());
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
