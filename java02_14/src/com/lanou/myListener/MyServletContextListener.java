package com.lanou.myListener;

import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyServletContextListener
 *  主要监听ServletContext
 */
@WebListener
public class MyServletContextListener implements ServletContextListener ,ServletContextAttributeListener{

	/**
	 * ServletContext对象创建时调用
	 */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
      System.out.println("应用创建");
    }
    
    /**
 	 * ServletContext对象销毁时调用
	 */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    	System.out.println("应用销毁");
    }
	
}
