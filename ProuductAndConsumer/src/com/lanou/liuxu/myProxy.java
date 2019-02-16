package com.lanou.liuxu;

/**
 * 代理对象
 * 
 * @author LiuXu
 * @time2018年8月7日上午11:10:06
 **/
public class myProxy implements Isubject {

	// 实例化真实的对象
	RealSubject realSubject = new RealSubject();

	@Override
	public void byMac() {
		//调用了代理对象自己的方法，相当于对真实对象类的一个扩充
		this.wrapMac();
		realSubject.byMac();
	}

	public myProxy(RealSubject realSubject) {
		super();
		this.realSubject = realSubject;

	}

	/**
	 * 代理对象自己的方法
	 */
	public void wrapMac() {
		System.out.println("去厂家买mac本");
	}

}
