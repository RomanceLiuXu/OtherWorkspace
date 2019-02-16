package com.lanou.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lanou.bean.User;
import com.lanou.service.DataBaseServiceE;
import com.lanou.service.interf.DataBaseServiceI;

/**
* 添加数据的接口
* @author LiuXu
* @time2018年7月19日下午8:20:23
**/
public class AddServletw extends HttpServlet{
   
	DataBaseServiceI dataService = new DataBaseServiceE(); 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    HttpSession session = req.getSession();
		//接收前端传来的值
		String name = req.getParameter("rcode");
		String psw = req.getParameter("rpsw");
		String sex = req.getParameter("sex");
		name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
		psw = new String(psw.getBytes("ISO-8859-1"), "UTF-8");
		sex = new String(sex.getBytes("ISO-8859-1"), "UTF-8");
		
		//调用service层的方法
		boolean isAdd = dataService.addUser(name, sex, psw);
		if (isAdd) {
			User user = new User(name, sex, psw);
			req.setAttribute("user", user);
			req.getRequestDispatcher("jsp/worklogin.jsp").forward(req, res);
		}else {
			req.getRequestDispatcher("jsp/workreginster.jsp").forward(req, res);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
