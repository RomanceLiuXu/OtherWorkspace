package Test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addsession
 */
@WebServlet("/addsession.do")
public class addsession extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 创建session对象（不存在则创建，存在则获取）
		/**
		 * 不存在：
		 *   1.第一个请求（请求消息头中没有sessionID）
		 *   2.请求消息头中有sessionID，但是根据sessionID没有找到相应的session对象（session时间失效或者服务器重启）
		 * 存在：
		 *   根据请求数据包中请求消息头携带的sessionID找到了相应的session对象
		 */
		
		
         HttpSession session = request.getSession();
         session.setAttribute("cishu", 10);
         response.getWriter().print("session add ok");
	}

}
