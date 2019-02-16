package com.lanou.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 *
 * @author LiuXu
 * @time2018年9月20日下午2:28:17
 **/

public class ProxyFactory implements MethodInterceptor {

	private Object real;

	public Object getProxy() {
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(real.getClass());
		// 设置回调函数
		enhancer.setCallback(this);
		return enhancer.create();
	}
    /**
     * arg0:代表委托对象
     * arg1:代理对象执行委托的方法
     * arg2:方法传入的参数
     * arg3:代表代理对象
     */
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2, MethodProxy arg3) throws Throwable {
		System.out.println("之前");
		arg1.invoke(real, arg2);
		System.out.println("之后");
		return null;
	}

}
