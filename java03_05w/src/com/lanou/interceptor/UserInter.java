package com.lanou.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 用户名为l的才可以访问
 * @author LiuXu
 * @time2018年7月31日下午9:39:44
 **/
public class UserInter extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String, Object> parameters = invocation.getInvocationContext().getParameters();
		String actionName = invocation.getProxy().getActionName();
		// 获取输入的用户名
		String[] userName = (String[]) parameters.get("user.name");
		String code = userName[0];
		if (actionName.equals("user_login")) {
			if (code.endsWith("l")) {
				return "home";
			} else {
				return "login";
			}
		}else {
			return "login";
		}

	}

}
