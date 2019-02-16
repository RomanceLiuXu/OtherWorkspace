package com.lanou.tset;

/**
 *
 * @author LiuXu
 * @time2018年8月7日下午2:52:22
 **/
public class WareHouse {

	private int max_size;// 仓库的最大容量
	private int nowcountl;// 仓库现有库存量

	public WareHouse(int max_size, int nowcountl) {
		super();
		this.max_size = max_size;
		this.nowcountl = nowcountl;
	}

	public synchronized void add(int pnum) {
		while (pnum + nowcountl > max_size) {
			System.out.println("超过库存量");
			try {
				wait();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
		}
		// 现在可以生产
		nowcountl += pnum;
		System.out.println("生产了" + pnum+"现在的库存量为:"+nowcountl);
		notifyAll();
	}

	public synchronized  void remove(int cnum) {
		while(nowcountl < cnum){
			
		}
		
	}
	
}
