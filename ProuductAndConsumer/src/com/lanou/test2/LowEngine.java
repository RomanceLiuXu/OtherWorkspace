package com.lanou.test2;

/**
 *
 * @author LiuXu
 * @time2018年8月7日上午9:44:38
 **/
public class LowEngine implements Engine {

	@Override
	public void run() {
	System.out.println("跑的慢");
		
	}

	@Override
	public void start() {
		
		System.out.println("启动慢");
	}

}
