package com.lanou.interceptor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 *
 * @author LiuXu
 * @time2018年7月31日上午11:31:00
 **/
public class Test3Interceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// List<String> urls = new ArrayList<>();
		// 获取请求action的名字
		String action = invocation.getProxy().getActionName();
		// 判断情请求的是登录页面还是主页面
		if (action.equals("user_login")) {
			return "login";
		} else if (action.equals("user_home")) {
			ActionContext ac = invocation.getInvocationContext();
			// 获取session对象
			Map<String, Object> session = ac.getSession();
			session.put("code", "lhl");
			// 通过key获取session容器中存的value值
			String string = (String) session.get("code");
			if (string != null && "".equals(string)) {
				// 存在则进入home主页面
				return "home";
			} else {
				// 不存在返回login登录页面
				return "login";
			}

		}
		return "error";

	}

}
