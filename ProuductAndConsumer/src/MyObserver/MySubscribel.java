package MyObserver;

/**
 * 抽象主体类
 * 
 * @author LiuXu
 * @time2018年8月7日下午8:59:13
 **/
public interface MySubscribel {

	
	public void addObserver(Observer ob);
	
	
	public void removeObserver(Observer ob);
	
	
	public void noticeAll();
}
