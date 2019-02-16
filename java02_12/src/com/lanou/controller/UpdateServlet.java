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
*
* @author LiuXu
* @time2018年7月19日下午11:13:12
**/
public class UpdateServlet extends HttpServlet{
	DataBaseServiceI dataService = new DataBaseServiceE(); 
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   HttpSession session = req.getSession();
		//获取数据
		String name = req.getParameter("name");
		String uidd = req.getParameter("uid");
		String sex = req.getParameter("sex");
		String psw = req.getParameter("psw");
		name = new String(name.getBytes("ISO-8859-1"), "UTF-8");
		psw = new String(psw.getBytes("ISO-8859-1"), "UTF-8");
		sex = new String(sex.getBytes("ISO-8859-1"), "UTF-8");
		if (uidd!=null&&!uidd.equals("")) {
		int	uid = Integer.parseInt(uidd);
		boolean isUpdate = dataService.updateUser(uid, name, sex, psw);
		if (isUpdate) {
			User user = new User(uid,name, sex, psw);
			session.setAttribute("user", user);
			session.setAttribute("isAdd", isUpdate);
		}
		
		}
		resp.sendRedirect("jsp/view.jsp");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
	
}
