package com.lanou.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * 实现拦截器的方式二
 * @author LiuXu
 * @time2018年7月31日上午11:01:39
 **/
public class Test2Interceptor implements Interceptor {

	@Override
	public void destroy() {
		
	}

	@Override
	public void init() {
		
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("拦截器2执行之前");
		arg0.invoke();
		System.out.println("拦截器2执行之后");
		return null;
	}

}
