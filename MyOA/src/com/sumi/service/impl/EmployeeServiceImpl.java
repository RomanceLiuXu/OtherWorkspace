package com.sumi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumi.bean.Department;
import com.sumi.bean.Employee;
import com.sumi.dao.inter.EmployeeDao;
import com.sumi.service.inter.EmployeeService;

/**
 *
 * @author LiuXu
 * @time2018年8月28日下午8:48:48
 **/
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	public List<Employee> findEmployees(int pageIndex, int pageNum) {
	
		return employeeDao.pageEmployee(pageIndex, pageNum);
	}

	
	@Override
	public List<Employee> findDeptEmps(String dname, int pageIndex, int pageNum) {
		if (dname!=null&&!"".equals(dname)) {
			return employeeDao.DeptEmployees(dname, pageIndex, pageNum);
		}	
			
		return null;
	}
	
	
	@Override
	public long findAllPage() {

		return employeeDao.allPage();
	}

	@Override
	public long findAllPage(String dname) {
	
		return employeeDao.allPage(dname);
	}


	@Override
	public List<Employee> findEmpsByDeptAndName(String dname, String uname) {
		
		return employeeDao.findEmpsByDeptAndName(dname, uname);
	}


	@Override
	public List<Employee> findEmpsByName(String uname) {
		
		return employeeDao.findEmpsByName(uname);
	}
	
	@Override
	public void addNewEmp(Department department, Employee employee) {
	     
		employeeDao.addNewEmp(department, employee);
	}


	@Override
	public List<Employee> findAdminEmp() {
		
		return employeeDao.findAdminEmp();
	}
	
	/****************************************************/
	@Override
	public Employee findEmpByJobnumAndPsw(String jobnum, String password) {
		Employee employee = null;
		if (nullCheck(jobnum, password)) {
			// 传入的账号密码不为空
			// 调用dao层登录验证的方法
			employee = employeeDao.findEmpByJobnumAndPsw(jobnum, password);
		}
		return employee;
	}
	/**
	 * 修改员工信息的方法
	 */
	@Override
	public void updateEmp(Employee emp,int uid) {
		//调用dao层修改员工信息的方法
		employeeDao.updateEmp(emp,uid);
	}

	/**
	 * 判空的方法
	 * 
	 * @param jobnum
	 *            工号
	 * @param password
	 *            密码
	 * @return
	 */
	private boolean nullCheck(String jobnum, String password) {
		// 判空
		if (jobnum != null && !jobnum.equals("") && password != null
				&& !password.equals("")) {
			// 不为空
			return true;
		}
		return false;
	}

	/**
	 * 修改密码
	 */
	@Override
	public void updatePsw(String password, int uid) {
		employeeDao.updatePsw(password, uid);
	}

	@Override
	public void deleteEmp(int uid) {
		employeeDao.deleteEmp(uid);
		
	}


	


	
	
	
}
