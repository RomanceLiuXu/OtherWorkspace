package com.sumi.util;

import java.util.Random;

/**
*获取一个四位的随机验证码的工具类
*@author SPF
*@time 2018年8月13日上午11:09:19
*/
public class RandomCode {
	public static String randomStr(){
		String str = "";
		//用for循环，得到一个包含所有大写、小写字母和数字的字符串
		for (int i = 0; i < 10; i++) {
			str+=i;
		}
		for (char i = 'a'; i <= 'z'; i++) {
			str+=i;
		}
		for (char i = 'A'; i <= 'Z'; i++) {
			str+=i;
		}
		//用来接收拿到的随机的四位的字符串
		String code = "";
		Random random = new Random();
		//转为字符数组
		char [] ch = str.toCharArray();
		//for循环4次，拿到一个四位的随机验证码
		for (int i = 0; i < 4; i++) {
			code+=ch[random.nextInt(ch.length)];
		}
		return code;
	}

}
