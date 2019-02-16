package MyObserver;

/**
 *
 * @author LiuXu
 * @time2018年8月7日下午9:13:27
 **/
public class User1 implements Observer {

	@Override
	public void update(String str) {
		System.out.println(str);

	}

}
