package com.lanou;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LiuXu
 * @time2018年7月5日下午2:27:51
 **/
public class Demo3 extends HttpServlet {

	/*
	 * 网络请求的方式 1.get的请求数据放在地址栏中，相对来说不安全
	 * 
	 */

	/**
	 * 执行post方法，当前端发送的是post请求，则执行该方法
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	/**
	 * 执行get方法，当前端发送的是get请求，则执行该方法
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.getWriter().println("lhl");
	}

}
