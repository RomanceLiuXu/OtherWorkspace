package com.lanou.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LiuXu
 * @time2018年7月12日下午9:51:06
 **/
public class PrintImage extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		// 获得服务器的地址，不能直接获取本机tomcat的绝对路径，不然游览器读取不了指定的图片文件
		// basePath的值是http://localhost:8080/flexTest
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/";
		System.out.println(basePath);
		 String showFile = "http://localhost:8080/java02_09/WEB-INF/marry/麻将.png";
//				 basePath+"/imge/"+this.filename;
		 out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01Transitional//EN\">");
		 out.println("<HTML>");
		 out.println(" <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		 out.println(" <BODY>");
		 out.print(" This is ");
		 out.print(" <img src=" + showFile + ">");
		 out.print("</img>");
		 System.out.println("有显示图片的地址是" + showFile);
		 // showFile的值是 http://localhost:8080/flexTest//imge/1299470395060.jpg
		 out.println(", using the POST method");
		 out.println(" </BODY>");
		 out.println("</HTML>");
		 out.flush();
		 out.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
