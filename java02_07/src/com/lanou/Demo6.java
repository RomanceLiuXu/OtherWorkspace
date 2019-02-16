package com.lanou;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author LiuXu
 * @time2018年7月6日下午3:41:28
 **/
public class Demo6 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 获取session对象
		HttpSession session = req.getSession(true);

		// 向session中添加值
		session.setAttribute("name", "lhl");
		session.setAttribute("age", 18);

		// 设置session的失效时间
		// 优先级：servlet-->web.xml-->conf-web.xml
		session.setMaxInactiveInterval(10);
		// 删除
		session.removeAttribute("name");
		// 清除session(杀死)
		// session.invalidate();
		res.sendRedirect("demo7");

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);

	}

}
