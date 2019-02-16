package com.sumi.dao.impl;

import java.util.List;
import java.util.Set;

import javax.print.DocFlavor.STRING;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sumi.bean.Department;
import com.sumi.bean.Employee;
import com.sumi.bean.Role;
import com.sumi.dao.inter.DeptDao;

/**
 *
 * @author LiuXu
 * @time2018年8月28日下午10:47:56
 **/
@Repository("deptDao")
public class DeptDaoImpl implements DeptDao{

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Override
	public void addDepartment(Department department) {
	
		hibernateTemplate.save(department);
	}

	@Override
	public void deleteDepartment(Department department) {
		hibernateTemplate.delete(department);
		
	}

	@Override
	public List<Department> findDepartments() {
		String hql = "from Department";
		return  (List<Department>) hibernateTemplate.find(hql);
	}
/********************************************************/
	
//	/**
//	 * 更新部门信息
//	 */
//	@Override
//	public void updateDept(Department department) {
//		hibernateTemplate.saveOrUpdate(department);
//		
//	}

	/**
	 * 根据部门名称查找部门对象
	 */
	@Override
	public Department findDeptByName(String dname) {
		//定义hql语句
		String hql = "from Department where dname=?";
		//执行查询
		List<Department> departments = (List<Department>) hibernateTemplate.find(hql,dname);
		if (departments.isEmpty()||departments.size()==0) {
			//集合为空
			return null;
		}
		return departments.get(0);
	}

	/**
	 * 更新部门信息
	 */
	@Override
	public Department updateDept(Department department) {
//		hibernateTemplate.update(department);
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Department department2 = (Department) session.get(Department.class, 1);
		return department2;
	}
	
	
	
	@Override
	public void updateEmpDept(Department department, int uid) {
	Employee employee = hibernateTemplate.get(Employee.class, uid);
	employee.setDepartment(department);
	hibernateTemplate.update(employee);
		
	}

	@Override
	public void updateEmpRole(int rid, int uid) {
		Role role = hibernateTemplate.get(Role.class, rid);
		Employee employee = hibernateTemplate.get(Employee.class, uid);
		employee.setRole(role);
		hibernateTemplate.update(employee);
		
	}
}
