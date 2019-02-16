package Test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addCoookie
 */
@WebServlet("/addCookie.do") // 注解
public class addCoookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("aaa");
		// 创建一个cookie对象
		Cookie cookie1 = new Cookie("name", "sch");
		Cookie cookie2 = new Cookie("cishu", "10");

		// 将cookie添加到响应数据包中带回
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.getWriter().println("cookie add ok");
	}

}
