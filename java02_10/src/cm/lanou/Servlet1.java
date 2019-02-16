package cm.lanou;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LiuXu
 * @time2018年7月11日上午9:32:42
 **/
public class Servlet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// 获取用户输入的内容
		String code = req.getParameter("code");
		String psw = req.getParameter("psw");

		// dao - 取数据 ---lhl 123

		// service---判断
		if (code != null && !code.equals("") && psw != null && !psw.equals("")) {

			if (code.equals("lhl") && psw.equals("123")) {
				// 方式一
				res.getWriter().println("home.html?code=" + code);
				// 方式二
				res.sendRedirect("home.html?name=" + code);
				// 方式三
				req.getRequestDispatcher("home.html").forward(req, res);
			} else {
				// 方式一
				res.getWriter().println("mylogin.html");
				// 方式二
				res.sendRedirect("login.html");
				// 方式三
				req.getRequestDispatcher("login.html").forward(req, res);
			}

		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		this.doGet(req, resp);
	}

}
