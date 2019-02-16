package com.lanou.myListener;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class CountSession
 *
 */
@WebListener
public class CountSession implements HttpSessionListener {
	// 统计session的个数
	int countSession = 0;

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent event) {
		System.out.println("session创建");
		// 每当创建一个session对象就自增1
		countSession++;
		ServletContext servletContext = event.getSession().getServletContext();
		servletContext.setAttribute("countSession", countSession);
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent event) {
		System.out.println("session销毁");
		countSession--;
		ServletContext servletContext = event.getSession().getServletContext();
		servletContext.setAttribute("countSession", countSession);
	}

}
