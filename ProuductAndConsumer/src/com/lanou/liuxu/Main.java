package com.lanou.liuxu;

import java.lang.reflect.Proxy;

/**
 *
 * @author LiuXu
 * @time2018年8月7日上午11:14:48
 **/
public class Main {

	public static void main(String[] args) {
		// 静态代理模式
		// RealSubject realSubject = new RealSubject();
		// myProxy proxy = new myProxy(realSubject);
		// proxy.byMac();

		// 动态代理方式一
		// 实例化真实的对象
		RealSubject real = new RealSubject();
		Proxy2 p2 = new Proxy2(real);
		// Proxy.newProxyInstance(loader, interfaces, h)
		// loader:一个ClassLoader对象，定义了由哪个ClassLoader对象来对生成的代理对象进行加载
		// interfaces:一个Interface对象的数组，表示的是我将要给我需要代理的对象提供一组什么接口，如果我提供了一组接口给它，
		// 那么这个代理对象就宣称实现了该接口(多态)，这样我就能调用这组接口中的方法了
		// h:
		// 一个InvocationHandler对象，表示的是当我这个动态代理对象在调用方法的时候，会关联到哪一个InvocationHandler对象上
		// 调用方法，产生动态代理对象（使用接口类型来描述)
		Isubject is = (Isubject) Proxy.newProxyInstance(real.getClass().getClassLoader(),	real.getClass().getInterfaces(), p2);
		// 调用方法
		is.byMac();

		// 动态代理方式二
		// 实例化真实的对象
		// RealSubject real = new RealSubject();
		// 实例化工厂类
		// ProxyFactory factory = new ProxyFactory(real);
		// 调用产生动态代理对象的方法（使用接口类型来描述）
		// Isubject isubject = (Isubject) factory.getProxyInstance();
		// isubject.byMac();

	}

}
