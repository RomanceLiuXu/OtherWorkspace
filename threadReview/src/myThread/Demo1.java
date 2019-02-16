package myThread;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 线程练习 -- 卖票
 * 
 * @author LiuXu
 * @time2018年6月7日下午9:17:26
 **/
public class Demo1 {
	/*
	 * 主函数
	 */
	public static void main(String[] args) {
		// 实例化
		ticketSale tc = new ticketSale();
		// 实例化线程
		Thread thread1 = new Thread(tc, "窗口1");
		Thread thread2 = new Thread(tc, "窗口2");
		Thread thread3 = new Thread(tc, "窗口3");
		// 使线程就绪
		thread1.start();
		thread2.start();
		thread3.start();

	}

}

/**
 * 卖票类
 * 
 * @author xalo
 *
 */
class ticketSale extends Thread {
 Integer ticketNum = 15;
	final Integer n = 1;

	@Override
	public void run() {
		super.run();
		// 锁赋值的属性
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
			synchronized (this) {
				if (ticketNum > 0) {
					
					ticketNum--;
					System.out.println(Thread.currentThread().getName() + "--"
							+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "卖了一张票," + "剩余票数:"
							+ ticketNum);
				} else {
					System.out.println("票已卖完");
					break;
				}

			}
			

		}
	}

}
