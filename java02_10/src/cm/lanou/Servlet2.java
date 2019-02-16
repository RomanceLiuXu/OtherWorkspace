package cm.lanou;

import java.io.IOException;

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
public class Servlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// String name = req.getParameter("name");
		// System.out.println(name);

		// String name = (String) req.getAttribute("name");
		// System.out.println(name);
		// System.out.println(name);
		//
		// String name = req.getParameter("code");
		// System.out.println(name);

		// Cookie[] cookies = req.getCookies();
		// String name = cookies[0].getName();
		// String value = cookies[0].getValue();
		// System.out.println(name + "--" + value);

		// HttpSession session = req.getSession();
		// String name = (String) session.getAttribute("name");
		// System.out.println(name);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
