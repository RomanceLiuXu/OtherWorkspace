package com.lanou.myListener;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 * 邮箱验证
 * 
 * @author LiuXu
 * @time2018年8月11日下午2:14:43
 **/
public class MailCode {

	public static void main(String[] args) {
		boolean is = sendEmail("601592939@qq.com", "1234");
		if (is) {
			System.out.println("发送成功");
		}else {
			System.out.println("发送失败");
		}
		
	}

	// 邮箱验证码
	public static boolean sendEmail(String emailaddress, String code) {

		try {
			HtmlEmail email = new HtmlEmail();
			email.setHostName("smtp.qq.com");//126邮箱为smtp.126.com,163邮箱为163.smtp.com，QQ为smtp.qq.com
			email.setCharset("UTF-8");
			email.addTo(emailaddress);//收件地址

			email.setFrom("liuxu043@qq.com", "RomanceLx");//此处填邮箱地址和用户名,用户名可以任意填写

			email.setAuthentication("liuxu043@qq.com", "kopoodwpnevwcbdj");//此处填写邮箱地址和客户端授权码
			email.setSubject("注册验证");//此处填写邮件名，可任意填写
			email.setMsg("尊敬的用户你好，你本次注册的验证码是:" + code);//此处填写邮件内容
			email.send();
		} catch (EmailException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

}
