package com.lanou.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lanou.service.LoginServiceE;
import com.lanou.service.interf.LoginServiceI;

/**
* 登录的接口
* @author LiuXu
* @time2018年7月18日上午11:04:24
**/
public class LoginServlet extends HttpServlet{
//实例化service层的对象
	LoginServiceI le= new LoginServiceE();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	    //获取数据(用户输入的内容)
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String flag = req.getParameter("flag");
		//判断
		//将数据传给service层
		boolean boo = le.checkLogin(username, password, flag,req,res);
		if (boo) {
			//跳转home界面
			req.getRequestDispatcher("jsp/home.jsp?username="+username).forward(req, res);
		}else{
			//跳转home界面
			req.getRequestDispatcher("jsp/home.jsp?msg='登录失败'").forward(req, res);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
