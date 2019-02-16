package java02_08work;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * session实现保存登录状态--登录验证
 * 
 * @author LiuXu
 * @time2018年7月9日下午7:36:46
 **/
public class loginCheck extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html;charset=utf-8");
		// 获取
		String code = req.getParameter("code");
		String psw = req.getParameter("psw");
		String enter = req.getParameter("enter");
		enter = URLEncoder.encode(enter, "ISO-8859-1");
		enter = URLDecoder.decode(enter, "UTF-8");
		code = URLEncoder.encode(code, "ISO-8859-1");
		code = URLDecoder.decode(code, "UTF-8");
		System.out.println(enter);
		// 获取数据库中的数据并进行匹配
		LoginJDBC jdbc = new LoginJDBC();
		boolean is = jdbc.jumpLogin(code, psw);
		if (is) {
			if (enter.equals("登录")) {
				// 跳转
				res.sendRedirect("res.html?flag=notsave");
			} else {
				// 设置session以及保存时间
				HttpSession session = req.getSession(true);
				session.setAttribute("code", code);
				session.setAttribute("psw", psw);
				session.setMaxInactiveInterval(24 * 60 * 60 * 5);
				// 跳转
				res.sendRedirect("res.html?flag=save");
			}
		} else {
			// 跳转
			res.sendRedirect("loginwork.html");
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
