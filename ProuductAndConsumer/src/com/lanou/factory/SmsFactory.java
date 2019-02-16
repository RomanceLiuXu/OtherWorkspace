package com.lanou.factory;

/**
 *
 * @author LiuXu
 * @time2018年8月7日下午5:35:06
 **/
public class SmsFactory implements Produce{

	@Override
	public Sender produe() {
	
		return new SmsSender();
	}

	
	
}
