package com.lanou.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

/**
*
* @author LiuXu
* @time2018年7月27日下午3:03:33
**/
public class Test7Action {

	public String saveMethod() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String code = request.getParameter("code");
		String psw = request.getParameter("psw");
		HttpSession session = request.getSession();
		if (code!=null&&!code.equals("")) {
			session.setAttribute("usercode1", code);
		}
		return "success";
	}
	
	
}
