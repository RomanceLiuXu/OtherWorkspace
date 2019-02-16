package ProuductConsumer;

/**
 * 仓库
 * 
 * @author LiuXu
 * @time2018年8月6日下午2:52:22
 **/
public class WareHouse {

	public static final int MAX_SIZE = 100;// 最大库存量
	public int curnum;// 当前库存量

	public WareHouse() {
	}

	public WareHouse(int curnum) {
		this.curnum = curnum;
	}

	/**
	 * 生产指定数量的产品
	 * 
	 * @param neednum
	 */
	public synchronized void produce(int neednum) {
		// 测试是否需要生产
		while (neednum + curnum > MAX_SIZE) {
			System.out.println("要生产的产品数量:" + neednum + "超过库存量" + (curnum + neednum - MAX_SIZE) + "个,暂时不能执行生产任务！");
			try {
				// 当前的生产线程等待
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 满足生产条件，则进行生产，这里简单更改当前库存量
		curnum += neednum;
		System.out.println(Thread.currentThread().getName() + ":已经生产了" + neednum + "个产品,先仓库量为" + curnum);
		// 唤醒在此对象监视器上等待的所有线程
		notifyAll();
	}

	/**
	 * 指定消费产品的数量
	 * 
	 * @param neednum
	 */
	public synchronized void consume(int neednum) {
		// 测试是否可消费
		while (curnum < neednum) {
			// 当前的消费线程等待
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// 满足消费条件，则进行消费，这里简单更改当前库存量
		curnum -= neednum;
		System.out.println(Thread.currentThread().getName() + ":已经消费了" + neednum + "个产品，现仓库存储量为" + curnum);
		// 唤醒在此对象监视器上等待的所有线程
		notifyAll();
	}

}
