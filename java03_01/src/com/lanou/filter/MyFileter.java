package com.lanou.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lanou.action.MyTest;

/**
 * 过滤器类
 * 
 * @author LiuXu
 * @time2018年7月26日上午9:29:16
 **/
public class MyFileter implements Filter {
	MyTest test = new MyTest();

	/**
	 * 销毁
	 */
	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("doFilter");
		// 通过强转获取一个HttpServletRequest和HttpServletResponse对象
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		// 通过request获取请求地址
		String uri = request.getRequestURI();
		PrintWriter pw = response.getWriter();
		System.out.println(uri);
		// 通过uri对不同的访问进行判断
		// 判断字符串中是否存在某些字符，如果存在，返回true
		if (uri.contains("test")) {
			// 实例化
			// 调用方法
			String str = test.method1();
			// 返回给前段
			pw.write(str);
		} else if (uri.contains("login")) {
			String str = test.method2();
			pw.print(str);
		}

	}

	/**
	 * 初始化
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("init");
	}

}
