package com.lanou.observes;

/**
 * 抽象主题接口
 * 
 * @author LiuXu
 * @time2018年8月7日下午2:09:44
 **/
public interface SubscribeI {

	/**
	 * 注册成为观察者的方法
	 * 
	 * @param o 观察者对象
	 */
	void addSubscribe(Observer o);

	/**
	 * 从观察列表移出该观察者
	 * 
	 * @param o 观察者对象
	 */
	void removeSubscribe(Observer o);
	
	/**
	 * 通知所有观察者
	 */
	void noticeAll();
}
