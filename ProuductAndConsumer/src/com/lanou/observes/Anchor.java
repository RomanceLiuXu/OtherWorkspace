package com.lanou.observes;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象主体的实现类
 * 
 * @author LiuXu
 * @time2018年8月7日下午2:16:43
 **/
public class Anchor implements SubscribeI {

	private List<Observer> observice;

	public Anchor() {
		observice = new ArrayList<>();
	}

	static class CreateAnchor {
		private static Anchor anchor = new Anchor();
	}

	/**
	 * 公共的静态方法获取对象
	 * 
	 * @return
	 */
	public static Anchor getAnchor() {

		return CreateAnchor.anchor;
	}

	@Override
	public void addSubscribe(Observer o) {
		if (o != null) {
			observice.add(o);
		}
	}

	@Override
	public void removeSubscribe(Observer o) {

	}

	@Override
	public void noticeAll() {

		for (Observer observer : observice) {
			observer.update("我上线了，快来围观");
		}
	}

	public void notice(){
		noticeAll();
	}
}
