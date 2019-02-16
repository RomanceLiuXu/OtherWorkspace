package com.liuxu.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 *
 * @author LiuXu
 * @time2018年7月31日上午10:05:10
 **/
public class LxInterceptor extends AbstractInterceptor {

	
	
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("intercept");
		System.out.println("方法执行之前");
		arg0.invoke();
//		Object action = arg0.getAction();
		ActionProxy proxy = arg0.getProxy();
		System.out.println(proxy.toString());
		System.out.println("方法执行之后");
		return null;
	}
    
	@Override
	public void init() {
		super.init();
		System.out.println("liuxu-init");
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("liuxu-destroy");
	}
}
