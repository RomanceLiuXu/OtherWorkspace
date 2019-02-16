package Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 通过阻塞队列实现生产者消费者模式
 * 
 * @author LiuXu
 * @time2018年8月6日下午9:02:26
 **/
public class TestConPro {
	public static void main(String[] args) {
		// 实例化阻塞队列
		BlockingQueue blockingQueue = new LinkedBlockingQueue(3);
		// 实例化生产者类
		Producer p = new Producer(blockingQueue);
		// 实例化消费者类
		Consumer c = new Consumer(blockingQueue);

		// 实例化线程
		Thread tp = new Thread(p);
		Thread tc = new Thread(c);

		tp.start();
		tc.start();

	}
}
