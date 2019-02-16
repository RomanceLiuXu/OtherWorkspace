/**
 *
 * @author LiuXu
 * @time2018年8月8日下午8:53:04
 **/
public class Test {

	public static void main(String[] args) {

		// 存在 i+1<i i的值为int类型的最大值
		// 存在 i-1>i i的值为int类型的最小值

		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;

		System.out.println(4.35 * 100);
		System.out.println(1 - 0.9);

		System.out.println(Math.sqrt(-9));
		System.out.println(5.2 / 0); 

		for (int i = 1; i <= 1000; i++) {
			if (method1(i)) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		// 分别表示公鸡，母鸡，小鸡的数量
		for (int i = 0; i < 20; i++) {
			// 买完公鸡剩余的钱数
			int y = 100 - 5 * i;
			for (int j = 0; j <= y / 3; j++) {
				// 买完母鸡之后剩余的钱数
				int y1 = y - j * 3;
				// 所能买的小鸡数
				int x = y1 * 3;
				if (i + j + x == 100) {
					System.out.println(i + " " + j + " " + x);
				}
			}
		}
	}

	public static boolean method1(int num) {
		int sum = 0;
		for (int i = 1; i <= num / 2; i++) {
			if (num % i == 0) {
				sum += i;
			}
		}
		if (sum == num) {
			return true;
		}
		return false;
	}
}
