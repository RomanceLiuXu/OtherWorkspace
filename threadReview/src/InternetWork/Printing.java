package InternetWork;

/**
 * 打印ABC
 * 
 * @author LiuXu
 * @time2018年6月9日下午4:14:34
 **/
public class Printing {

	public static void main(String[] args) {

		// 实例化
		Object object = new Object();

		PrintA pa = new PrintA(object);
		PrintB pb = new PrintB(object);
		PrintC pc = new PrintC(object);

		pa.start();
		pb.start();
		pc.start();
		
	}

}

/*
 * 打印A类
 */
class PrintA extends Thread {

	Object Object;

	public PrintA() {
		super();
	}

	public PrintA(java.lang.Object object) {
		super();
		Object = object;
	}

	@Override
	public void run() {
		synchronized (Object) {
			for (int i = 0; i < 10; i++) {
				System.out.print("A");
				try {
					Object.wait();
					Object.notify();
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
			super.run();
		}
	}

}

/*
 * 打印B类
 */
class PrintB extends Thread {

	Object Object;

	public PrintB() {
		super();
	}

	public PrintB(java.lang.Object object) {
		super();
		Object = object;
	}

	@Override
	public void run() {
		synchronized (Object) {
			for (int i = 0; i < 10; i++) {
				System.out.print("B");
				try {
					Object.wait();
					Object.notify();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			super.run();
		}
	}

}

/*
 * 打印C类
 */
class PrintC extends Thread {

	Object Object;

	public PrintC() {
		super();
	}

	public PrintC(java.lang.Object object) {
		super();
		Object = object;
	}

	@Override
	public void run() {
		synchronized (Object) {
			for (int i = 0; i < 10; i++) {
				System.out.print("C");
				try {
					Object.notify();
					System.out.println();
					Object.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			super.run();
		}
	}

}
