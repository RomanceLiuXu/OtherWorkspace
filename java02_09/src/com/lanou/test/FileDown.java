package com.lanou.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author LiuXu
 * @time2018年7月10日下午3:08:52
 **/
public class FileDown extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// /Users/xalo/Downloads/魔方.png
		// 实例化file
		File file = new File("/Users/xalo/Library/tomcat/wtpwebapps/java02_09/WEB-INF/upicture/erji.png");
		// 读取文件
		// 获取ServletOutputStream对象
		// ServletOutputStream sos = res.getOutputStream();
		FileInputStream fis = new FileInputStream(file);
		byte[] bytes = new byte[fis.available()];
		// byte[] bytes = new byte[1024];
		fis.read(bytes);
		// 获取ServletOutputStream对象
		ServletOutputStream sos = res.getOutputStream();
		// 写入数据
		sos.write(bytes);
		// 刷新
		sos.flush();
		sos.close();
		fis.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
