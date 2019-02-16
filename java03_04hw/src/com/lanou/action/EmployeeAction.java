package com.lanou.action;

import com.lanou.bean.Employee;
import com.lanou.service.EmployeeService;
import com.lanou.service.interf.EmployeeServiceI;

/**
 * 添加员工
 * 
 * @author LiuXu
 * @time2018年7月30日下午9:40:24
 **/
public class EmployeeAction {

	private Employee employee;

	public String employeeAction() {
		String result = "error";
		System.out.println(employee);
		String[] strs = { employee.getName(), employee.getSex()};
		if (IsNull(strs) && employee.getAge() > 0) {
			EmployeeServiceI service = new EmployeeService();
			result = service.addEmployee(employee);
		}
		return result;
	}

	public boolean IsNull(String[] strs) {
		for (String string : strs) {
			if (string == null || string.equals("")) {
				return false;
			}
		}
		return true;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}
