package com.lanou.interceptor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.lanou.bean.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 *
 * @author LiuXu
 * @time2018年7月31日下午7:19:53
 **/
public class UserInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("intercept");
		// 获取ActionContext对象
		ActionContext ac = invocation.getInvocationContext();
		// 获取前端的输入值
		 HttpServletRequest request = (HttpServletRequest) ac.getContext().get(ServletActionContext.HTTP_REQUEST);
		 String userName = request.getParameter("user.name");
		 String userPsw = request.getParameter("user.psw");
		// 获取action对象的代理对象
		ActionProxy proxy = invocation.getProxy();
		// 获取当前执行的action名
		String actionName = proxy.getActionName();
		// 获取session值
		Map<String, Object> session = ac.getSession();
		Object object = session.get("user");
		if ("user_login".equals(actionName)&&IsNulls(userName)&&IsNulls(userPsw)) {
			invocation.invoke();
		} else if ("user_home".equals(actionName)) {
			if (object != null && !"".equals(object)) {
				System.out.println(object);
				return "home";
			}else {
				return "login";
			}
		}else {
			return "login";
		}
		return null;
	}

	public boolean IsNulls(String str) {
		if (str==null||str.equals("")) {
			return false;
		}
		return true;
	}
	
}
