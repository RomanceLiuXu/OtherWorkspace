package com.lanou.liuxu;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理---方式二
 * 
 * 利用匿名内部类的方式实现
 * 
 * @author LiuXu
 * @time2018年8月7日下午4:51:41
 **/
public class ProxyFactory {

	private Object real;

	public ProxyFactory(Object real) {
		super();
		this.real = real;
	}

	// 通过代理工厂给目标对象生成代理对象
	public Object getProxyInstance() {
		// Proxy.newProxyInstance(loader, interfaces, h)
		// loader:一个ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载
		// interfaces:一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，
		// 那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
		// h:一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上
		return Proxy.newProxyInstance(real.getClass().getClassLoader(), real.getClass().getInterfaces(),new InvocationHandler() {
					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("开始之前");
						Object obj = method.invoke(real, args);
						System.out.println("开始之后");
						return obj;
					}
				});
	}

}
