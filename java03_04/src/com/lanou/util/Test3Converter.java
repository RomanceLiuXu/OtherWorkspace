package com.lanou.util;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.lanou.bean.Test3Entity;

/**
 *
 * @author LiuXu
 * @time2018年7月30日下午5:11:02
 **/
public class Test3Converter extends StrutsTypeConverter{

//前端--String-->后台--自定义类型
//	arg0:上下文 
//	arg1:传入的数据数组
//	arg2:需要转到的类型(目标类型)
	
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		System.out.println("--------");
		System.out.println(arg1);
	    String con = arg1[0];
	    String[] strs = con.split(",");
	    Test3Entity entity = new Test3Entity(strs[0], strs[1]);
		return entity;
	}

	
	@Override
	public String convertToString(Map arg0, Object arg1) {
		
		
		return null;
	}


	
	
	
}
