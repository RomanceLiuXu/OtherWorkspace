package ProuductConsumer;

/**
 * 消费者
 * 
 * @author LiuXu
 * @time2018年8月6日下午3:11:57
 **/
public class Consumer extends Thread {

	private int neednum;// 生产产品的数量
	private WareHouse wareHouse;// 仓库

	public Consumer(int neednum, WareHouse wareHouse) {
		this.neednum = neednum;
		this.wareHouse = wareHouse;
	}

	@Override
	public void run() {
		// 消费指定数量的产品
		wareHouse.consume(neednum);
	
	}
}
