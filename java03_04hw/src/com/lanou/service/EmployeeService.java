package com.lanou.service;

import com.lanou.bean.Employee;
import com.lanou.dao.EmployeeDao;
import com.lanou.dao.interf.EmployeeDaoI;
import com.lanou.service.interf.EmployeeServiceI;

/**
*
* @author LiuXu
* @time2018年7月30日下午10:02:28
**/
public class EmployeeService implements EmployeeServiceI{

	@Override
	public String addEmployee(Employee employee) {
		String result="";
		if (employee!=null) {
			EmployeeDaoI dao = new EmployeeDao();
			result = dao.addEmployee(employee);
		}
		return result;
	}

	
}
