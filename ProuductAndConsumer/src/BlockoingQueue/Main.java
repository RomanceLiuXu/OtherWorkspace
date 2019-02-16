package BlockoingQueue;

/**
 *
 * @author LiuXu
 * @time2018年8月6日下午8:37:58
 **/
public class Main {

	public static void main(String[] args) {
		Storage storage = new Storage();

		 new Thread(new Producer1(storage), "生产者线程").start();;
		 new Thread(new Consumer1(storage), "消费者线程").start();;

		
	}
}
