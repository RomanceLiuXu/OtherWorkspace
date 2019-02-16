package com.lanou;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 第一种实现方式
 * 
 * @author LiuXu
 * @time2018年7月5日上午11:00:03
 **/
public class Demo1 implements Servlet {

	/**
	 * servlet 初始化的方法 1.该函数用于初始化该servlet 2.该函数只会被调用一次（当用户第一次访问该servlet时被调用）
	 */
	@Override
	public void init(ServletConfig arg0) throws ServletException {
		System.out.println("init");
	}

	/**
	 * 
	 * 执行业务的方法 1、该函数用于处理业务逻辑 2、程序员应当把业务逻辑代码写在这里 3、当用户每访问一次该Servlet时都会被调用
	 * 4、ServletRequest--用户获取客户端(浏览器)的信息 5、ServletResponse--用于客户端返回信息
	 */

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

		System.out.println("service");
		// 设置编码格式（servlet向前端发送中文乱码的情况）
		res.setContentType("text/html;charset=utf-8");
		// 向前段页面写入内容
		// 使用res获取PrintWriter对象
		PrintWriter pw = res.getWriter();
		pw.println("lhl");
		pw.println("蓝鸥科技");

	}

	/**
	 * 销毁的方法 1.reload(改servlet) 2.关闭tomcat 3.关机
	 */
	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	public ServletConfig getServletConfig() {
		System.out.println("ServletConfig");
		return null;
	}

	@Override
	public String getServletInfo() {
		System.out.println("getServletInfo");
		return null;
	}

}
