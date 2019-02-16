package Test;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * 主要用于监听request的创建和销毁
 *
 */
@WebListener
public class CountListener implements ServletRequestListener {

	// 定义变量用于统计有多少个请求
	int countRequest = 0;

	public void requestDestroyed(ServletRequestEvent event) {
		System.out.println("request请求创建");
		// 每当有一个请求过来，就将计数变量加1
		countRequest++;
		// 然后将新的计数变量存储起来
		ServletContext servletContext = event.getServletContext();
		servletContext.setAttribute("countRequest", countRequest);
	}

	public void requestInitialized(ServletRequestEvent event) {
		System.out.println("request请求销毁");
	}

}
