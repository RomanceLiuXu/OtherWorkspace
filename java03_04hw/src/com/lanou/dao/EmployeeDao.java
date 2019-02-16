package com.lanou.dao;

import com.lanou.bean.Employee;
import com.lanou.dao.interf.EmployeeDaoI;
import com.lanou.util.SQLUtil2;

/**
 *
 * @author LiuXu
 * @time2018年7月30日下午10:03:33
 **/
public class EmployeeDao implements EmployeeDaoI {

	@Override
	public String addEmployee(Employee employee) {
		String result = "error";
		if (employee != null) {
			String sql = "insert into employee values(?,?,?,?)";
			String[] parm = { 0 + "", employee.getName(), employee.getSex(), employee.getAge() + "" };
			boolean IsAdd = SQLUtil2.updateMethod(sql, parm);
			if (IsAdd) {
				result = "success";
			}
			
		}

		return result;
	}

}
