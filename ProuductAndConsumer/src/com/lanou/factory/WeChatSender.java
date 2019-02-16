package com.lanou.factory;

/**
 *
 * @author LiuXu
 * @time2018年8月7日下午8:21:42
 **/
public class WeChatSender implements Sender{

	@Override
	public void send() {
		System.out.println("微信消息");
		
	}

	
	
}
