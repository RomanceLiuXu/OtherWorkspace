package com.liuxu.fan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author LiuXu
 * @time2018年6月28日下午5:50:07
 **/
public class Demo3 {

	public static void main(String[] args) throws ParseException {

		// 实例化 -- 获取当前时间
		Date date = new Date();

		System.out.println(date);
		// 常用方法
		// 1.获取时间戳 -- 1970-01-01 00：00：00到现在的毫秒数 使时间交流无障碍
		long t = date.getTime();
		System.out.println(t);
//		时间戳--时间
	    Date d2 = new Date(999999999999999999l);
	    System.out.println(d2);
//	     2.获取年 月 日 时 分 秒
	    System.out.println(date.getYear()+1900);//年  1900年为0
	    System.out.println(date.getMonth() + 1);//月   0开始
	    System.out.println(date.getDate());//日
	    System.out.println(date.getDay());//星期  0为周日
      
//	    格式化日期
	    
//	    SimpleDateFormat sd = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒 E");
	    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
	    String s = sd.format(date);
	    System.out.println(s);
	    
//	    将字符串装换为日期
	    String str = "2018年5月4日";
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
	    //将字符串时间转换为日期
	    Date date1 = dateFormat.parse(str);
	    System.out.println(date1);
	    
	    
	}

}
