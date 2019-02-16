package com.lanou.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lanou.service.DataBaseServiceE;
import com.lanou.service.interf.DataBaseServiceI;

/**
*
* @author LiuXu
* @time2018年7月19日下午11:29:08
**/
public class DeleteServlet extends HttpServlet{
	DataBaseServiceI dataService = new DataBaseServiceE(); 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			//接收前端传来的值
		    String uidd = req.getParameter("uid");
			//String name = req.getParameter("name");
			//name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
			int uid = Integer.parseInt(uidd);
			boolean isDelete = dataService.deleteUser(uid);
			if (isDelete) {
				resp.sendRedirect("pagew?page=1");
			}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
