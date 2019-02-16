package com.lanou;

/**
 * 线程睡眠方法---阻塞状态
 * 
 * @author LiuXu
 * @time2018年6月4日下午5:22:51
 **/
public class Demo4 extends Thread {

	@Override
	public void run() {

		super.run();
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
			System.out.println(i);
		}
	}

}
