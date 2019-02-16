package Internet2;

/**
 *
 * @author LiuXu
 * @time2018年6月10日下午5:10:57
 **/
public class myThread {

	// 子线程循环2次，主线程循环2次，然后子线程循环2次，主线程循环2次，这样循环10次；
	public static void main(String[] args) {
		MyWork mw = new MyWork();
		new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					mw.sub();
				}

			}
		}).start();

		for (int i = 0; i < 10; i++) {
			mw.myMain();
		}

	}

}

class MyWork {
	private boolean flag = false;// 判断是否等待

	public synchronized void sub() {
		while (flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
		for (int i = 0; i < 2; i++) {
			System.out.println("sub--" + i);
		}
		flag = true;
		this.notify();
	}

	public synchronized void myMain() {
		while (!flag) {
			try {
				this.wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
		for (int i = 0; i < 2; i++) {
			System.out.println(Thread.currentThread().getName() + "--" + i);
		}
		flag = false;
		this.notify();

	}
}