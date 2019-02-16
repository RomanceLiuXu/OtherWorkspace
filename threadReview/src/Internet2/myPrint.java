package Internet2;

/**
 * 打印ABC
 * 
 * @author LiuXu
 * @time2018年6月9日下午6:08:04
 **/
public class myPrint {

	public static void main(String[] args) {
     
	    PrintABC pr = new PrintABC();
	    
	    new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					pr.printA();
				}
				
			}
		}).start();
	    
	    new Thread(new Runnable() {
	    	
	    	@Override
	    	public void run() {
	    		for (int i = 0; i < 10; i++) {
	    			pr.printB();
	    		}
	    		
	    	}
	    }).start();
	    
	    new Thread(new Runnable() {
	    	
	    	@Override
	    	public void run() {
	    		for (int i = 0; i < 10; i++) {
	    			pr.printC();
	    		}
	    		
	    	}
	    }).start();
		
	
	
	}

}

/*
 * 打印ABC类
 */
class PrintABC {
	private int flag = 1;

	public synchronized void printA() {
		while (flag != 1) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print("A");
		flag = 2;
		this.notifyAll();
	}

	public synchronized void printB() {
		while (flag != 2) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print("B");
		flag = 3;
		this.notifyAll();
	}

	public synchronized void printC() {
		while (flag != 3) {
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.print("C");
		flag = 1;
		this.notifyAll();
	}

}