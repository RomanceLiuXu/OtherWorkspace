package myThread;
/**
*
* @author LiuXu
* @time2018年6月9日上午11:39:54
**/
public class Demo3 implements Runnable{

	String str;
	
	
	
	public Demo3() {
		super();
	}



	public Demo3(String str) {
		super();
		this.str = str;
	}



	@Override
	public void run() {
		synchronized (str) {
			for (int i = 0; i < 10; i++) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName()+":"+i);
			}	
		}
		
		
	}

}
