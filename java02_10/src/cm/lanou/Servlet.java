package cm.lanou;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LiuXu
 * @time2018年7月11日上午10:55:59
 **/
public class Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 方式一
		// 重定向
		res.sendRedirect("servlet2?name=lhl");

		// 分发
		req.setAttribute("name", "lhl");
		req.getRequestDispatcher("servlet2").forward(req, res);

		//方式三
		PrintWriter pw = res.getWriter();
		pw.println("<html>");
		pw.println("<body>");
		pw.println("<form action='servlet2' method='post'>");
		pw.println("<input type='text' name='code' hidden value='lhl'/><br />");
		pw.println("<input type='submit' value='登录' />");
		pw.println("</form>");
		pw.println("</body>");
		pw.println("</html>");

		// 方式四
		Cookie c1 = new Cookie("name", "lhl");
		res.addCookie(c1);
		res.sendRedirect("servlet2");

		// 方式五
		HttpSession session = req.getSession();
		session.setAttribute("name", "lhl");
		res.sendRedirect("servlet2");
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
