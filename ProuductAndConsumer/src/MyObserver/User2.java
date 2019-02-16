package MyObserver;

/**
 *
 * @author LiuXu
 * @time2018年8月7日下午9:14:07
 **/
public class User2 implements Observer {

	@Override
	public void update(String str) {
		System.out.println(str);

	}

}
