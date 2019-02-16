package com.lanou.factory;

/**
 *
 * @author LiuXu
 * @time2018年8月7日下午5:42:01
 **/
public class MailFactory implements Produce{

	@Override
	public Sender produe() {
		
		return new MailSender();
	}

	
	
	
}
