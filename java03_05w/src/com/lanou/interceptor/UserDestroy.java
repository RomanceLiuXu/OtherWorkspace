package com.lanou.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 用户注销的拦截器
 * 
 * @author LiuXu
 * @time2018年7月31日下午10:07:52
 **/
public class UserDestroy extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {

		String actionName = invocation.getProxy().getActionName();
		
		if ("user_destroy".equals(actionName)) {

			return invocation.invoke();
		}

		return "home";
	}

}
