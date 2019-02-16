package Test;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author LiuXu
 * @time2018年8月6日下午9:01:29
 **/
public class Producer implements Runnable {

	// 实例化队列
	private final BlockingQueue blockingQueue;
	// 设置队列缓存的大小。生产过程中超过这个大小就暂时停止生产
	// private final int QUEUE_SIZE = 10;

	public Producer(BlockingQueue blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	int task = 1;

	@Override
	public void run() {

		while (true) {
			try {
				// 将生产出来的产品放在队列缓存中
				blockingQueue.put(task);
				System.out.println("正在生产：" + task);
				++task;
				// 让其停止一会，便于查看效果
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
}
