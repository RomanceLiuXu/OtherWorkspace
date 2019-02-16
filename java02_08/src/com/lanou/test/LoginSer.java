package com.lanou.test;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录对应的servlet
 * 
 * @author LiuXu
 * @time2018年7月9日下午3:24:56
 **/
public class LoginSer extends HttpServlet {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html;charset=utf-8");
		// 获取前端传来的数据
		String code = req.getParameter("code");
		String psw = req.getParameter("psw");
		code = URLEncoder.encode(code, "ISO-8859-1");
		code = URLDecoder.decode(code, "UTF-8");
		System.out.println(code);
		// 实例化
		LoginJDBC jdbc = new LoginJDBC();
		boolean is = jdbc.jumpLogin(code, psw);
		if (is) {
			// 登录成功
			res.sendRedirect("res.html?res=success");
		} else {
			// 登录失败
			res.sendRedirect("res.html?res=error");
		}

		// // 定义一个标示
		// boolean is = false;
		//
		// // 连接数据库并获取数据
		// try {
		// Class.forName("com.mysql.jdbc.Driver");
		// con = DriverManager.getConnection(
		// "jdbc:mysql://localhost:3306/mywork?useUnicode=true&characterEncoding=UTF-8",
		// "root", "123456");
		// ps = con.prepareStatement("select * from student");
		// rs = ps.executeQuery();
		// while (rs.next()) {
		// String p1 = rs.getString("s_id");
		// String c1 = rs.getString("s_name");
		// if (p1.equals(psw) && c1.equals(code)) {
		// is = true;
		// break;
		// }
		//
		// }
		//
		// if (is) {
		// // 登录成功
		// res.sendRedirect("res.html?res=success");
		// } else {
		// // 登录失败
		// res.sendRedirect("res.html?res=error");
		// }
		//
		// } catch (ClassNotFoundException e) {
		//
		// e.printStackTrace();
		// } catch (SQLException e) {
		//
		// e.printStackTrace();
		// }

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
