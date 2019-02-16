package myThread;

/**
 * 锁账户
 * 
 * @author LiuXu
 * @time2018年6月9日下午2:23:08
 **/
public class Demo6 {

	public static void main(String[] args) {

		Person p1 = new Person();
		Person p2 = new Person();

		Account account = new Account();

		p1.setpName("妻子");
		p2.setpName("丈夫");

		p1.setAccount(account);
		p2.setAccount(account);

		p1.setMoney(100);
		p2.setMoney(200);

		p1.start();
		p2.start();

	}

}

/*
 * 人类
 */
class Person extends Thread {
	String pName;// 姓名
	Account account;// 账户
	int money;// 取的钱数

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public void run() {
		super.run();
		while (true) {
			if (account.allMoney > 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {

					e.printStackTrace();
				}
				synchronized (account) {
					if (account.allMoney > 0) {
						System.out.println(pName + "正在取钱...");
						account.allMoney -= money;
						System.out.println(pName + "取了" + money + ",余额为:" + account.allMoney);
					}

				}
			}
		}
	}

}

/*
 * 账户类
 * 
 */
class Account {
	Integer allMoney = 1000;// 总钱数

}
