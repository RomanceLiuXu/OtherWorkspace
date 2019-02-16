package com.lanou.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 注册接口
 * 
 * @author LiuXu
 * @time2018年7月23日下午8:18:02
 **/
public class workLogin extends HttpServlet {
    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         //获取数据
		String rcode = req.getParameter("rcode");
		String rpsw = req.getParameter("rpsw");
		String rsex = req.getParameter("sex");
		
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
