package com.match.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonObject;
import com.match.beans.UserP;
import com.match.dao.HomeDaoE;
import com.match.service.HomeServiceE;

/**
 * 分页查询
 * 
 * @author LiuXu
 * @time2018年7月16日下午10:31:10
 **/
public class PageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 设置编码格式
		res.setContentType("text/html;charset=utf-8");
		PrintWriter pw = res.getWriter();
		// 获取前端传来的数据（性别）
		// String sex = req.getParameter("sex");
		String sex = "男";
		// 获取页码
		String ppage = req.getParameter("page");
		// int page = 2;
		int page = 0;
		if (ppage != null && !ppage.equals("")) {
			page = Integer.parseInt(ppage);
		}
		// 定义每页显示的个数
		int pnum = 6;
		// 实例化，调用dao层的方法获取总页数
		HomeDaoE homeDaoE = new HomeDaoE();
		// 实例化，调用service层
		HomeServiceE homeServiceE = new HomeServiceE();
		if (sex != null && !sex.equals("")) {
			// 获取总页数
			int allPage = homeDaoE.allPage(sex, pnum);
			// 调用方法，获取结果的集合
			List<UserP> pageFind = homeServiceE.pageFind(sex, pnum, page);
			String jsonString = JSON.toJSONString(pageFind);
			String jsonStr = jsonString + allPage;
			pw.println(jsonStr);
			System.out.println("分页:" + jsonStr);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
