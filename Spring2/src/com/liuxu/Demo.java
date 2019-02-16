package com.liuxu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author LiuXu
 * @time2018年8月24日上午10:26:46
 **/
@Component("demo")
public class Demo {

	@Autowired
	public static String userName;
	
	
	public static void show(String str){
		str = userName +"测试";
		System.out.println(str);
	}
	
}



