package myThread;

/**
 *
 * @author LiuXu
 * @time2018年6月9日上午11:37:45
 **/
public class Demo2 extends Thread {
	String str;

	public Demo2() {
		super();
	}

	public Demo2(String str) {
		super();
		this.str = str;
	}

	@Override
	public void run() {
		super.run();
		synchronized (str) {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + ":" + i);
			}
		}

	}
}
