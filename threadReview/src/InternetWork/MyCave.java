package InternetWork;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 过山洞
 * 
 * @author LiuXu
 * @time2018年6月9日下午3:54:44
 **/
public class MyCave {

	public static void main(String[] args) {
		// 实例化
		Cave cave = new Cave();

		// 实例化线程
		for (int i = 1; i < 11; i++) {
			Thread thread = new Thread(cave, i + "号");
			thread.start();
		}
	}

}

/*
 * 过山洞类
 */
class Cave extends Thread {

	@Override
	public void run() {
		super.run();
		synchronized (this) {

			System.out.println(Thread.currentThread().getName() + "正在过山洞...");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName()+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())+ "--穿过山洞");
		}
	}
}