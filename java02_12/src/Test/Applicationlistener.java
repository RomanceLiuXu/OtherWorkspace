package Test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author LiuXu
 * @time2018年8月10日上午11:48:52
 **/
public class Applicationlistener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
	   System.out.println("contextInitialized");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed");
	}
}
