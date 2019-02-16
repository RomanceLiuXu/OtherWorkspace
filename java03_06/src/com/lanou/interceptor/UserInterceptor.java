package com.lanou.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 *
 * @author LiuXu
 * @time2018年8月1日上午11:29:23
 **/
public class UserInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String actionName = invocation.getProxy().getActionName();
		HttpServletRequest request = (HttpServletRequest) invocation.getInvocationContext()
				.get(ServletActionContext.HTTP_REQUEST);
		HttpSession session = request.getSession();
		Object sName = session.getAttribute("name");
		if (actionName.equals("login")) {
			// 登录操作
			String name = request.getParameter("name");
			String psw = request.getParameter("psw");
			String flag = request.getParameter("flag");
//			System.out.println(name+"--"+psw+"--"+flag+"in");
			String[] strs = { name, psw, flag };
			if (IsNull(strs)) {
//			System.out.println("进入action");
			  invocation.invoke();
			}
			return "error";
		} else if (actionName.equals("home")) {
			if (sName!=null) {
				return "home";
			}
			return "error";
		}
		return null;
	}

	public boolean IsNull(String[] strs) {
		for (String string : strs) {
			if (string == null || "".equals(string)) {
				return false;
			}
		}
		return true;
	}
}
