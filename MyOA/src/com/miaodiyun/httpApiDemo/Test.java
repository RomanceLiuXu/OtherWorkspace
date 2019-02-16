package com.miaodiyun.httpApiDemo;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 获取开发者账号信息
		// AccountInfo.execute();

		// 产生的随机验证码
		String r = IndustrySMS.getRandomNum(6);
		System.out.println(r);
		// 给谁发的短信
		String to = "18829298795";
		// 验证码通知短信接口
		IndustrySMS.execute(to, r);
		// 会员营销短信接口
		// AffMarkSMS.execute();

		// 语音验证码
		// VoiceCode.execute();

	}
}
