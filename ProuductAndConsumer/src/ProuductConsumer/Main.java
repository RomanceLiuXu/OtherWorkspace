package ProuductConsumer;

/**
 *
 * @author LiuXu
 * @time2018年8月6日下午2:42:19
 **/
public class Main {
	public static void main(String[] args) {
		// 实例化仓库
		WareHouse wareHouse = new WareHouse(20);
		// 消费者线程
//		Consumer c2 = new Consumer(20, wareHouse);
//		Consumer c1 = new Consumer(50, wareHouse);
		// Consumer c3 = new Consumer(100, wareHouse);
		// 生产者线程
//		Producer p1 = new Producer(30, wareHouse);
		// Producer p2 = new Producer(10, wareHouse);
		// Producer p3 = new Producer(10, wareHouse);
		// Producer p4 = new Producer(10, wareHouse);
		// Producer p5 = new Producer(10, wareHouse);
		// Producer p6 = new Producer(10, wareHouse);
		// Producer p7 = new Producer(10, wareHouse);
		
		
		
		
		Thread th3 = new Thread(new Producer(50, wareHouse), "生产者者线程1");
		Thread th4 = new Thread(new Producer(10, wareHouse), "生产者者线程2");
		
		Thread th1 = new Thread(new Consumer(20, wareHouse), "消费者线程1");
		Thread th2 = new Thread(new Consumer(50, wareHouse), "消费者线程2");
		
		
        
		


		th1.start();
		th2.start();
		th3.start();
		th4.start();
		
		// c1.start();
		// c2.start();
		// c3.start();
		//
		// p1.start();
		// p2.start();
		// p3.start();
		// p4.start();
		// p5.start();
		// p6.start();
		// p7.start();

	}
}
