package com.lanou.factory;

/**
 * 工厂方法模式
 * 
 * @author LiuXu
 * @time2018年8月7日下午5:21:22
 **/
public class Main {

	public static void main(String[] args) {

		// Produce produce = new MailFactory();
		// Sender produe = produce.produe();
		// produe.send();

		Produce weChat = new WeChatFactory();
		Sender produe = weChat.produe();
		produe.send();

	}

}
