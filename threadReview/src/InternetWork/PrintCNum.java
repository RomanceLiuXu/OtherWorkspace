package InternetWork;

/**
 * 打印数字和字母
 * @author LiuXu
 * @time2018年6月9日下午5:03:40
 **/
public class PrintCNum {

	public static void main(String[] args) {
		// 写两个线程，一个线程打印1~52，另一个线程打印A~Z，打印顺序是12A34B...5152Z；
		MyPrint mp = new MyPrint();
		new Thread(new Runnable() {

			@Override
			public void run() {

				mp.method1();

			}
		}).start();
		
		new Thread(new Runnable() {

			@Override
			public void run() {

				mp.method2();

			}
		}).start();

	}

}

/*
 * 打印类
 */
class MyPrint {
	static Boolean is = true;

	public synchronized void method1() {
		while (is == true) {
			for (int i = 1; i < 27; i++) {
				System.out.print(2 * i - 1);
				System.out.print(2*i);
				is = false;
				try {
					this.notify();
					this.wait();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
			return;
		}
		
	}

	public synchronized void method2() {
		while (is == false) {
			for (char i = 'A'; i <= 'Z'; i++) {
				System.out.print(i);

				try {
					this.notify();
					is = true;
					this.wait();
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
			}
			return;
		}
		
	}


}
