package myThread;

/**
 * 锁余额
 * 
 * @author LiuXu
 * @time2018年6月9日下午1:54:21
 **/
public class Demo5 {

	public static void main(String[] args) {
		GetMoney gm1 = new GetMoney("妻子");
		GetMoney gm2 = new GetMoney("丈夫");
		
		gm1.setsMoney(200);
		gm2.setsMoney(100);

		gm1.start();
		gm2.start();

	}
}

/*
 * 取钱类
 */
class GetMoney extends Thread {
	static Integer allMoney = 1000;// 总金额
	 int sMoney;// 取的钱数
	String pName;// 姓名

	private static final Integer n = 1;

	public static Integer getAllMoney() {
		return allMoney;
	}

	public static void setAllMoney(Integer allMoney) {
		GetMoney.allMoney = allMoney;
	}

	public  int getsMoney() {
		return sMoney;
	}

	public  void setsMoney(int sMoney) {
		this.sMoney = sMoney;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public GetMoney(String pName) {
		super();
		this.pName = pName;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			if (allMoney > 0) {
				
				synchronized (n) {
					if (allMoney > 0) {
						System.out.println(pName + "正在取钱...");
						
						allMoney -= sMoney;
						
						System.out.println(pName + "取钱:" + sMoney + ",余额为:" + allMoney);
						super.run();
					}
					
				}
			}
		}
	}

}