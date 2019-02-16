package myThread;

/**
 *
 * @author LiuXu
 * @time2018年6月9日下午1:50:20
 **/
public class Demo4 extends Thread {
  String str;
	
	
	
	public Demo4() {
	super();
}



	public Demo4(String str) {
	super();
	this.str = str;
}



	@Override
	public void run() {
		super.run();
		for (int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + ":" + i);
		}
	}

}
