package com.lanou.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lanou.bean.User;
import com.lanou.dao.DatabaseDaoE;
import com.lanou.dao.interf.DataBaseDaoI;
import com.lanou.service.DataBaseServiceE;
import com.lanou.service.interf.DataBaseServiceI;

/**
 *
 * @author LiuXu
 * @time2018年7月23日下午8:51:17
 **/
public class pageServlet extends HttpServlet {
	DataBaseServiceI dataService = new DataBaseServiceE(); 
	DataBaseDaoI datadao = new DatabaseDaoE();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 获取页码
		String ppage = req.getParameter("page");
		HttpSession session = req.getSession();
		// 每页显示的个数
		int pnum = 6;
		// 调用方法
		// int page = 2;
		int page = 0;
		if (ppage != null && !ppage.equals("")) {
			page = Integer.parseInt(ppage);
		}
		if (page==1) {
			int allPage = datadao.allPage(pnum);
			session.setAttribute("allpage", allPage);
		}
		List<User> pageFind = dataService.pageFind(pnum, page);
//		System.out.println(pageFind);
		req.setAttribute("pagefind", pageFind);
		req.getRequestDispatcher("jsp/workhome.jsp").forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}
}
