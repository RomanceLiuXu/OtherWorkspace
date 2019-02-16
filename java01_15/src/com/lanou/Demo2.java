package com.lanou;

/**
 * 实现线程的方法2 ---实现接口
 * 
 * @author LiuXu
 * @time2018年6月4日下午3:52:02
 **/
public class Demo2 implements Runnable {

	private String name;

	public Demo2() {
		super();
	}

	public Demo2(String name) {
		super();
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name + ":" + i);
		}

	}

}
