package com.lanou;

/**
 *
 * @author LiuXu
 * @time2018年8月7日上午9:23:42
 **/
public class SmsSender implements Sender{

	@Override
	public void send() {
		System.out.println("sms发送了一条消息");
	}

}
