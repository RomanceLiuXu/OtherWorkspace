package com.lanou;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 数据共享
 * 
 * @author LiuXu
 * @time2018年7月6日上午9:03:12
 **/
public class Demo1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 第一种方式
		// 跳转到某个servlet
		// res.sendRedirect("demo2?name=liuxu");
		// 重定向
		// 设置编码格式
		res.setContentType("text/html;charset=utf-8");

		// 第二种方式 form表单
		PrintWriter pw = res.getWriter();
		pw.println("<body>");
		pw.println("<form action = 'demo2' method = 'get'>");
		pw.println("<input type='text' name='msg' hidden='hidden' value='lhl' />");
		pw.println("<input type='submit' value='提交'/>");
		pw.println("</form>");
		pw.println("</body>");

		// 第三种方式
		// 重定向
		// 实例化
		// Person person = new Person("lhl", 18);
		// 传送一个对象

		// 给req设置一个属性
		// req.setAttribute("person", person);
		// 跳转并传递参数
		// 参数:
		// 参数1:arg0:需要跳转的servlet,这里我们使用子对象
		// 参数2:arg0:传递的ServletRequest对象,这里我们使用子对象
		// 参数3:arg1:传递的对象ServletResponse对象
		// req.getRequestDispatcher("demo2").forward(req, res);
		// req.getRequestDispatcher("demo2?name=liuxu").forward(req, res);
		// 分发 || 重定向
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
