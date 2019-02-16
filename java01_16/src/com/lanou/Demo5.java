package com.lanou;

/**
 * 线程实现卖票的过程
 * 
 * @author LiuXu
 * @time2018年6月5日下午5:20:12
 **/
public class Demo5 {

	public static void main(String[] args) {
		
		SellTickets s1 = new SellTickets();
		s1.setName("窗口1");
		SellTickets s2 = new SellTickets();
		s2.setName("窗口2");
		SellTickets s3 = new SellTickets();
		s3.setName("窗口3");

		s1.start();
		s2.start();
		s3.start();
	}
}

class SellTickets extends Thread {
    static Integer pollNum = 10;// 票数
	private static Integer n = 1;


	@Override
	public void run() {
		super.run();
		while (pollNum > 0) {
			synchronized (n) {
				if (pollNum > 0) {
					// try {
					// Thread.sleep(1000);
					// } catch (InterruptedException e) {
					// e.printStackTrace();
					// }
				System.out.println(Thread.currentThread().getName() + "正在卖票");
				pollNum--;
				System.out.println(Thread.currentThread().getName() + "买了一张票，剩余" + pollNum + "张票");
			}
			}
		}
		System.out.println("票已卖完!");
	}

}