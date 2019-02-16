package com.sumi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumi.bean.Department;
import com.sumi.bean.Employee;
import com.sumi.dao.inter.DeptDao;
import com.sumi.service.inter.DeptService;

/**
 *
 * @author LiuXu
 * @time2018年8月28日下午10:50:26
 **/
@Service("deptService")
public class DeptServiceImpl implements DeptService{

	@Autowired
	public DeptDao deptDao;
	
	@Override
	public void addDepartment(Department department) {
		deptDao.addDepartment(department);
		
	}

	@Override
	public void deleteDepartment(Department department) {
		
		deptDao.deleteDepartment(department);
	}

	@Override
	public List<Department> findDepartments() {
	
		return deptDao.findDepartments();
	}

	 /************************************************/ 
	/**
	 * 根据部门名称查找部门对象
	 */
	@Override
	public Department findDeptByName(String dname) {
		return deptDao.findDeptByName(dname);
	}

	/**
	 * 更新部门信息
	 */
	@Override
	public Department updateDept(Department department) {
		//执行更新
		return deptDao.updateDept(department);
	}


	@Override
	public void updateEmpDept(Department department, int uid) {
		deptDao.updateEmpDept(department, uid);
		
	}

	@Override
	public void updateEmpRole(int rid, int uid) {
		deptDao.updateEmpRole(rid, uid);
		
	}

}
