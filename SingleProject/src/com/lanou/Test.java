package com.lanou;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author LiuXu
 * @time2018年8月8日下午2:33:16
 **/
public class Test implements A,B{

	public static void main(String[] args) {
		
		SimpleDateFormat f = new SimpleDateFormat("HH:mm:ss");
		
		
		// String regex1 = "[0-9]";
		String regex = "垃圾|菜鸟";
		String str = "你个垃圾，菜鸟";
		// System.out.println(str.matches(regex));

		// 封装正则表达式的对象
		Pattern pattern = Pattern.compile(regex);
		// 封装正则表达式和字符串的匹配结果
		Matcher matcher = pattern.matcher(str);
		// 判断是否匹配:matcher.find()
		// System.out.println(matcher.find());
		// 取出匹配上的字符串
		// String group = matcher.group();
		// System.out.println(group);
		// 取出字符串中能和正则表达式匹配上的子串
		while (matcher.find()) {
			str = str.replace(matcher.group(), "**");
		}
		System.out.println(str);

	}

	@Override
	public boolean m() {
	
		return false;
	}
}

interface A {
	boolean m();
}

interface B {
	boolean m();
}