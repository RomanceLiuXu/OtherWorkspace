package ProuductConsumer;

/**
 *
 * @author LiuXu
 * @time2018年8月6日下午3:18:26
 **/
public class Producer extends Thread {

	private int neednum;// 生产产品的数量
	private WareHouse wareHouse;// 仓库

	public Producer() {
	}

	public Producer(int neednum, WareHouse wareHouse) {
		this.neednum = neednum;
		this.wareHouse = wareHouse;
	}

	@Override
	public void run() {
		// 生产指定数量的产品
		wareHouse.produce(neednum);
	}
}
