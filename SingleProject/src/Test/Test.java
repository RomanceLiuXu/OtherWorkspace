package Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer实现倒计时
 * 
 * @author LiuXu
 * @time2018年8月8日下午5:20:30
 **/
public class Test {

	public static void main(String[] args) {
		Timer timer = new Timer();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		timer.schedule(new TimerTask() {
			// 总时间
			long time = System.currentTimeMillis();

			@Override
			public void run() {
				String format = sdf.format(time);
				System.out.println(format);
				time -= (long)365 * 24 * 60 * 60 * 1000;
				if (time == 0) {
					timer.cancel();
				}
			}
		}, 1000, 1000);
	}

}
