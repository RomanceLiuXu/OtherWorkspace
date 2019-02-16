package myThread;

/**
 * 窗口卖票
 * 
 * @author LiuXu
 * @time2018年6月9日下午2:43:06
 **/
public class Demo7 {

	public static void main(String[] args) {
		saleTicket1 st = new saleTicket1();
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(st, "窗口" + (i + 1));
			thread.start();
		}

	}
}
	/*
	 * 卖票类
	 */
	class saleTicket1 extends Thread {
		private int ticketNum = 20;// 总票数

		@Override
		public void run() {
			super.run();
			while (true) {

				synchronized (this) {
					if (ticketNum > 0) {
						try {
							Thread.sleep(1000);
						} catch (InterruptedException e) {

							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName() + "正在卖票...");
						ticketNum--;
						System.out.println(Thread.currentThread().getName() + "卖了1张票,余票为:" + ticketNum);
					} else {
						System.out.println("票已售完");
						break;
					}

				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}

			}
		}
	}

