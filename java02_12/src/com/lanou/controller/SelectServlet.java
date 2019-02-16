package com.lanou.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lanou.bean.User;
import com.lanou.service.DataBaseServiceE;
import com.lanou.service.interf.DataBaseServiceI;

/**
*
* @author LiuXu
* @time2018年7月19日下午11:35:00
**/
public class SelectServlet extends HttpServlet{
	DataBaseServiceI dataService = new DataBaseServiceE();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		  HttpSession session = req.getSession();
		  List<User> users = dataService.selectUser();
		  session.setAttribute("users", users);
		  resp.sendRedirect("jsp/select.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
