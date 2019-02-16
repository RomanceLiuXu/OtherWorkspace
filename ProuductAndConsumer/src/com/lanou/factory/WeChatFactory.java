package com.lanou.factory;

/**
 *
 * @author LiuXu
 * @time2018年8月7日下午8:21:18
 **/
public class WeChatFactory implements Produce{

	@Override
	public Sender produe() {
	
		return new WeChatSender();
	}

}
