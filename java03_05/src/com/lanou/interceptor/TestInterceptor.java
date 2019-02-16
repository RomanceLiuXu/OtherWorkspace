package com.lanou.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 *
 * @author LiuXu
 * @time2018年7月31日上午9:36:10
 **/
public class TestInterceptor extends AbstractInterceptor {

	/**
	 * 拦截器的方法
	 */
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		System.out.println("intercept");
		System.out.println("拦截器执行之前");
		// 放行(通过拦截器执行action中的动作)
		 arg0.invoke();
		System.out.println("拦截器执行之后");
		return "error";
	}

	/**
	 * 销毁的方法
	 */
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("destroy");
	}

	/**
	 * 初始化方法
	 */
	@Override
	public void init() {
		super.init();
		System.out.println("init");
	}
}
