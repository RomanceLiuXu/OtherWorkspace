package MyObserver;

import java.util.ArrayList;
import java.util.List;



/**
*
* @author LiuXu
* @time2018年8月7日下午9:03:11
**/
public class Anchor implements MySubscribel{

	private List<Observer> observers;
	
	 public Anchor() {
		 observers = new ArrayList<>();
	}
	
//单例模式
	 static class CreatAnchor{
		private static Anchor anchor = new Anchor(); 
	 }
	 
	 public static Anchor getAnchor() {
		
		 return CreatAnchor.anchor;
	}
	 
	 
	 
	@Override
	public void addObserver(Observer ob) {
		if (ob!=null) {
			observers.add(ob);
		}
		
	}

	@Override
	public void removeObserver(Observer ob) {
		if (ob!=null) {
			observers.remove(ob);
		}
		
	}

	@Override
	public void noticeAll() {
		for (Observer observer : observers) {
			observer.update("来来来");
		}
	}
	
	

	

	

}
