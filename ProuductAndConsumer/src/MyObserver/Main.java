package MyObserver;

/**
 *
 * @author LiuXu
 * @time2018年8月7日下午9:14:46
 **/
public class Main {

	public static void main(String[] args) {
      Anchor anchor = Anchor.getAnchor();
      Observer user1 = new User1();
      Observer user2 = new User2();
      anchor.addObserver(user1);
      anchor.addObserver(user2);
      anchor.noticeAll();
		
	}
}
