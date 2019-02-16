package com.lanou.factory;
/**
*
* @author LiuXu
* @time2018年8月7日下午5:32:31
**/
public class SmsSender implements Sender{

	@Override
	public void send() {
		System.out.println("短信发送的消息");
	}

}
