package myThread;

/**
 *
 * @author LiuXu
 * @time2018年6月9日上午11:41:27
 **/
public class myMain {

	public static void main(String[] args) {

		String str = new String();
		// // 实例化
		Demo2 d2 = new Demo2(str);
		// 设置线程名
		d2.setName("线程1");
		// 启动线程
		d2.start();
		// 实例化
		Demo3 d3 = new Demo3(str);
		Thread thread2 = new Thread(d3);
		// 设置线程名
		thread2.setName("线程2");
		// 启动线程
		thread2.start();
		

		// 实例化
		Demo4 d4 = new Demo4();
		// 设置线程名
		d4.setName("线程3");
		// 启动线程
		d4.start();

	}

}
