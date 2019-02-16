package com.lanou.bean;

/**
 *
 * @author LiuXu
 * @time2018年8月21日下午4:46:51
 **/
public class ExampleBean {
  
	public ExampleBean(){
		System.out.println("--构造器--");
	}
	
	/**初始化方法：bean组件实例化之后调用*/
	public void init() {
		System.out.println("--init()初始化--");
	}
    /** 销毁方法*/
	public void destroy() {
		System.out.println("--destroy()销毁--");
	}
}
