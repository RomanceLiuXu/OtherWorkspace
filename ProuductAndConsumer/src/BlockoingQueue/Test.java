package BlockoingQueue;

import java.util.concurrent.LinkedBlockingDeque;

/**
 *
 * @author LiuXu
 * @time2018年8月6日下午7:41:35
 **/
public class Test {

	private static LinkedBlockingDeque<String> queue = new LinkedBlockingDeque<>(10);

	public void produce() {
		try {
			queue.put("生产了一个任务");
			System.out.println(Thread.currentThread().getName() + "生产一个"+",库存量:"+queue.size());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public String consume() {
		try {
			String consume = queue.take();
			System.out.println(Thread.currentThread().getName() + "消费一个,库存量:"+queue.size());
			return consume;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return null;
		}

	}

	public static void main(String[] args) {
		Test test = new Test();
		
		Thread th1 = new Thread(new Producer(test), "生产者线程1");
		Thread th2 = new Thread(new Consumer(test), "消费者线程1");
           
		th1.start();
		th2.start();
	}
}

class Producer implements Runnable {

	private Test test;

	public Producer(Test test) {
		this.test = test;
	}

	@Override
	public void run() {
		while (true) {
			test.produce();
		}

	}

}

class Consumer implements Runnable {

	private Test test;

	public Consumer(Test test) {
		this.test = test;
		
	}

	@Override
	public void run() {
		while (true) {
			test.consume();
		}
	}

}
