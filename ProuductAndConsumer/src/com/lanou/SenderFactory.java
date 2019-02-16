package com.lanou;

/**
 *
 * @author LiuXu
 * @time2018年8月7日上午9:24:40
 **/
public class SenderFactory {

	
	public static Sender mail() {
		
		return new MailSender();
	}
	
	public static Sender sms() {
		
		return new SmsSender();
	}
	
}
