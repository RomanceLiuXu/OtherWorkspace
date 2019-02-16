package Test;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author LiuXu
 * @time2018年8月6日下午9:00:09
 **/
public class Consumer implements Runnable {

	// 阻塞队列
	private final BlockingQueue blockingQueue;

	public Consumer(BlockingQueue blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	@Override
	public void run() {
		// 只要阻塞队列中有任务，就一直去消费
		while (true) {
			try {
				System.out.println("正在消费： " + blockingQueue.take());
				// 让其停止一会，便于查看效果
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
