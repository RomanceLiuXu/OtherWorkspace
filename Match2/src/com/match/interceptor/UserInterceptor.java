package com.match.interceptor;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 *
 * @author LiuXu
 * @time2018年8月3日下午7:23:00
 **/
public class UserInterceptor extends AbstractInterceptor {

	// 用户拦截器
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		String actionName = invocation.getProxy().getActionName();
		HttpServletRequest request = (HttpServletRequest) invocation.getInvocationContext().get(ServletActionContext.HTTP_REQUEST);
		String name1 = request.getParameter("name");
		String psw1 =request.getParameter("psw");
		System.out.println(name1 + "--" + psw1);
		if ("login".equals(actionName)) {
			if (IsNull(name1)&&IsNull(psw1)) {
				invocation.invoke();
			}else {
				return "error";
			}
		}else if ("home".equals(actionName)) {
			invocation.invoke();
		}
		return null;
	}
    
	public boolean IsNull(String str){
		if (str==null||"".equals(str)) {
			return false;
		}
		return true;
	} 
	
}
