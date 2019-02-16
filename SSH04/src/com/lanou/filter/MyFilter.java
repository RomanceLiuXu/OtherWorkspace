package com.lanou.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 *  自定义过滤器，用于处理中文乱码
 * @author LiuXu
 * @time2018年9月10日下午4:54:59
 **/
//@WebFilter("*.do")
public class MyFilter implements Filter{
     /**过滤器初始化
      * config:过滤器初始化时给其传的初始化参数
      *  容器启动时调用
      * */
	@Override
	public void init(FilterConfig config) throws ServletException {
	   System.out.println("--过滤器初始化--");
	   String value = config.getInitParameter("encoding");
	}
	
	/**
	 * 执行过滤的方法
	 * 请求到达时调用
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("过滤器前置逻辑");
//		只有这个方法调用了，才能让请求通过过滤器，到达后续的过滤器或者servlet
		request.setCharacterEncoding("UTF-8");
		chain.doFilter(request, response);
		System.out.println("过滤器后置逻辑");
		response.setContentType("text/html;charset=UTF-8");
	}

	/**销毁的方法*/
	@Override
	public void destroy() {
		
		Filter.super.destroy();
	}
	
}
