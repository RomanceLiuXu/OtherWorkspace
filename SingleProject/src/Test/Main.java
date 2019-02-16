package Test;

import java.text.SimpleDateFormat;

/**
*
* @author LiuXu
* @time2018年8月8日下午10:11:48
**/
public class Main {

	
	public static void main(String[] args) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long time = System.currentTimeMillis() - (long)(365 * 24 * 60 * 60 * 1000);
		System.out.println(sdf.format(time));
	}
}
