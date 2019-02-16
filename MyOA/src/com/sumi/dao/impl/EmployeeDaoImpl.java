package com.sumi.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sumi.bean.Department;
import com.sumi.bean.Employee;
import com.sumi.bean.Role;
import com.sumi.dao.inter.EmployeeDao;

/**
 *
 * @author LiuXu
 * @time2018年8月28日下午4:57:42
 **/
@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	// 分页查询
	@Override
	public List<Employee> pageEmployee(int pageIndex, int pageNum) {
//		List<Employee> employees = hibernateTemplate.execute(new HibernateCallback<List<Employee>>() {
//			@Override
//			public List<Employee> doInHibernate(Session session) throws HibernateException {
//				String hql = "from Employee";
//				Query query = session.createQuery(hql);
//				int start = (pageIndex - 1) * pageNum;
//				query.setFirstResult(start);
//				query.setMaxResults(pageNum);
//				List<Employee> employees = query.list();
//				return employees;
//			}
//		}); 
		Session session = hibernateTemplate.getSessionFactory().openSession();
		String hql = "from Employee";
		Query query = session.createQuery(hql);
		int start = (pageIndex - 1) * pageNum;
		query.setFirstResult(start);
		query.setMaxResults(pageNum);
		List<Employee> employees = query.list();
		return employees;
	}

	@Override
	public List<Employee> DeptEmployees(String dname,int pageIndex,int pageNum) {
		String hql="from Employee where department.dname=?";
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, dname);
		int start = (pageIndex - 1) * pageNum;
		query.setFirstResult(start);
		query.setMaxResults(pageNum);
		List<Employee> employees = query.list();
		return employees;
		
	}
	
	// 查询总页数
	@Override
	public long allPage() {
		String hql = "select count(*) from Employee";
		List<Long> allPage = (List<Long>) hibernateTemplate.find(hql);
		if (allPage.isEmpty() || allPage.size() == 0) {
			return 0;
		}
		long all = allPage.get(0);
		return all;
	}

	@Override
	public long allPage(String dname) {
		String hql = "select count(*) from Employee where department.dname=?";
		List<Long> allPage = (List<Long>) hibernateTemplate.find(hql,dname);
		if (allPage.isEmpty() || allPage.size() == 0) {
			return 0;
		}
		long all = allPage.get(0);
		return all;
		
	}

	@Override
	public List<Employee> findEmpsByDeptAndName(String dname,String uname) {
		String hql="from Employee where department.dname=? and uname=?";
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, dname);
		query.setString(1, uname);
		List<Employee> employees = query.list();
		return employees;
	}

	@Override
	public List<Employee> findEmpsByName(String uname) {
		String hql="from Employee where uname=?";
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setString(0, uname);
		List<Employee> employees = query.list();
		return employees;
	}
	
	@Override
	public void addNewEmp(Department department,Employee employee) {
		Department d2 = hibernateTemplate.get(Department.class, department.getDid());
		Role role = hibernateTemplate.get(Role.class, 1);
		employee.setRole(role);
		employee.setPassword("12345");
		employee.setDepartment(d2);
		employee.setHiredate(new Date());
	    d2.getEmployees().add(employee);
	    hibernateTemplate.update(d2);
	}

	@Override
	public List<Employee> findAdminEmp() {
		String hql = "from Employee where role.rid=?";
		List<Employee> employees = (List<Employee>) hibernateTemplate.find(hql,2);
		return employees;
	}
	
	
	/****************************************************************************************/
	/**
	 * 根据工号和密码查找员工对象
	 * 登录
	 */
	@Override
	public Employee findEmpByJobnumAndPsw(String jobnum, String password) {
		// 定义hql语句
		String hql = "from Employee where jobnum=? and password=?";
		List<Employee> employees = (List<Employee>) hibernateTemplate.find(hql,
				jobnum, password);
		 if (employees.isEmpty()||employees.size()==0) {
		 return null;
		 }
		return employees.get(0);
	}

	/**
	 * 更改员工信息
	 */
	@Override
	public void updateEmp(Employee emp,int uid) {
		//根据uid获取员工对象
		Employee employee = hibernateTemplate.get(Employee.class, uid);
		//设置员工需要修改的信息
		employee.setSex(emp.getSex());
		employee.setEmail(emp.getEmail());
		employee.setAddress(emp.getAddress());
		employee.setPhone(emp.getPhone());
		//执行更新
		hibernateTemplate.update(employee);
	}

	/**
	 *修改密码
	 */
	@Override
	public void updatePsw(String password, int uid) {
		//根据uid查找员工对象
		Employee employee = hibernateTemplate.get(Employee.class, uid);
		//设置新密码
		employee.setPassword(password);
		//执行更新
		hibernateTemplate.update(employee);
		
	}


	@Override
	public void deleteEmp(int uid) {
		//根据员工id查找员工对象
				Employee employee = hibernateTemplate.get(Employee.class, uid);
				employee.getDepartment().getEmployees().remove(employee);
				employee.setDepartment(null);
				hibernateTemplate.clear();
				hibernateTemplate.delete(employee);
	}

	

	

}
