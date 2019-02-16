package com.lanou.factory;

/**
 *
 * @author LiuXu
 * @time2018年8月7日下午5:33:43
 **/
public class MailSender implements Sender {

	@Override
	public void send() {
		System.out.println("邮件发送的消息");
	}

}
