package com.lanou.interceptor;

import com.lanou.bean.User;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 *
 * @author LiuXu
 * @time2018年8月1日下午11:15:10
 **/
public class UpdateInterceptor extends AbstractInterceptor {

	private User user;

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// String actionName = invocation.getProxy().getActionName();
		System.out.println(user.toString());
		if (user != null) {
			String[] strs = { user.getUid() + "", user.getName() };
			if (IsNull(strs)) {
				invocation.invoke();
			}

		} else {
			return "home";
		}

		return null;
	}

	public boolean IsNull(String[] strs) {
		for (String string : strs) {
			if (string == null || string.equals("")) {
				return false;
			}
		}
		return true;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
