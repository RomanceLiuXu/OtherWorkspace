package com.lanou.liuxu;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 动态代理--实现方式一 实现InvocationHandler接口
 * 
 * @author LiuXu
 * @time2018年8月7日上午11:22:33
 **/
public class Proxy2 implements InvocationHandler {

	private Object real;

	public Proxy2(Object real) {
		super();
		this.real = real;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("买之前");
		// 使用Method对象调用invoke方法
		method.invoke(real, args);
		System.out.println("买之后");
		return null;
	}

}
