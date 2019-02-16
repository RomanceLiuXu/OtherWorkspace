package com.sumi.action;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sumi.bean.Department;
import com.sumi.bean.Employee;
import com.sumi.bean.Role;
import com.sumi.service.inter.DeptService;
import com.sumi.service.inter.RoleService;

/**
 *
 * @author LiuXu
 * @time2018年8月29日上午9:04:51
 **/
@Controller("deptAction")
public class DeptAction implements SessionAware {

	@Autowired
	private DeptService deptService;
	@Autowired
	private RoleService roleService;
	private String dname;// 添加部门，Manager有此权限
	private List<Department> departments;
	private int uid;// 前端获取的要操作员工的id
	private int rid;// 前端获取的权限id
	private Map<String, Object> session;
	private List<Role> roles;
	private Set<Employee> employees;
	private String msg;

	public String findUidD() {
		session.put("uid", uid);
		departments = deptService.findDepartments();
		session.put("departments", departments);
		return "idD_suc";
	}

	public String findUid() {
		session.put("uid", uid);
		roles = roleService.findRoles();
		session.put("roles", roles);
		return "id_suc";
	}

	// 修改员工部门
	public String updateEmpDept() {
		// 查找部门对象
		Department department = deptService.findDeptByName(dname);
		uid = (int) session.get("uid");
		deptService.updateEmpDept(department, uid);
		return "dept_suc";
	}

	// 修改员工权限
	public String updateEmpRole() {
		System.out.println("--------------------------------------");
		System.out.println(rid);
		uid = (int) session.get("uid");
		deptService.updateEmpRole(rid, uid);
		return "role_suc";
	}

	// 添加部门
	public String addDepartment() {
		deptService.addDepartment(new Department(0, dname));

		return "add_suc";
	}

	// 删除部门
	public String deleteDepartment() {

		deptService.addDepartment(new Department(0, dname));

		return "del_suc";
	}

	// 查询所有的部门
	public String findDepartment() {
		departments = deptService.findDepartments();
		session.put("departments", departments);
		return "find_suc";
	}

	// 通讯录(按部门)
	public String findMessage() {
		departments = deptService.findDepartments();
		System.out.println("findMessage()中，前端传来的名称为：" + dname);
		employees = deptService.findDeptByName(dname).getEmployees();
		return "success";
	}

	// 根据部门名称删除一个部门
	public String deleteDeptByName() {
		Department department = deptService.findDeptByName(dname);
		System.out.println("删除时前端传来的名称：" + dname);
		if (department.getEmployees().isEmpty() || department.getEmployees().size() == 0) {
			// 没有员工，可以删除
			msg = "yes";
			deptService.deleteDepartment(department);
			return "success";
		}
		msg = "no";
		return "success";
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {

		this.session = arg0;
	}

}
