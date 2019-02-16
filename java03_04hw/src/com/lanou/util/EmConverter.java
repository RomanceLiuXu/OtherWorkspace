package com.lanou.util;

import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

import com.lanou.bean.Employee;

/**
 *
 * @author LiuXu
 * @time2018年7月30日下午10:16:40
 **/
public class EmConverter extends StrutsTypeConverter {

	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {

		String str = arg1[0];
		String[] strs = str.split(",");
		Employee employee = new Employee(strs[0], strs[1], Integer.parseInt(strs[2]));

		return employee;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		return null;
	}

}
