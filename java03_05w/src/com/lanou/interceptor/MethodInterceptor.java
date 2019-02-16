package com.lanou.interceptor;

import com.opensymphony.xwork2.ActionInvocation;

import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

/**
 *
 * @author LiuXu
 * @time2018年7月31日下午11:12:21
 **/
public class MethodInterceptor extends MethodFilterInterceptor {

	
	@Override
	protected String doIntercept(ActionInvocation invocation) throws Exception {
		System.out.println("method--doIntercept");
		return null;
	}

}
