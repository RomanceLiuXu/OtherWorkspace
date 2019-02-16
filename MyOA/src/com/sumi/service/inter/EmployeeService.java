package com.sumi.service.inter;

import java.util.List;

import com.sumi.bean.Department;
import com.sumi.bean.Employee;

/**
*
* @author LiuXu
* @time2018年8月28日下午8:48:26
**/
public interface EmployeeService {

	/**
	 * 
	 * @param pageIndex 页码
	 * @param pageNum 每页显示的个数
	 * @return 查询的人员集合
	 */
	public List<Employee> findEmployees(int pageIndex,int pageNum);
	
	
	/**
	 * 根据部门名称查找所有对应的员工
	 * @param dname
	 * @return
	 */
	public List<Employee> findDeptEmps(String dname,int pageIndex,int pageNum);
	
	
	  /**
     * 根据部门和员工姓名查找所有员工
     * @return
     */
	public List<Employee> findEmpsByDeptAndName(String dname,String uname);

	/**
	 * 根据员工姓名查找员工
	 * @return
	 */
	public List<Employee> findEmpsByName(String uname);
	
	
	/**
	 * 查询总页数
	 * @param pageNum 每页显示的个数
	 * @return
	 */
	public long findAllPage();
	
	/**
	 * 查询总页数
	 * @param pageNum 每页显示的个数
	 * @return
	 */
	public long findAllPage(String pname);
	
	/**
     * 给部门新增员工的方法
     * @param department
     */
	public void addNewEmp(Department department,Employee employee);
	
	
	/**
	 * 查找所有管理员(admin)
	 * @return
	 */
	public List<Employee> findAdminEmp();
	
	/*********************************************************/
	/**
	 * 根据工号和密码查找一个员工对象
	 * @param jobnum 传入的工号
	 * @param password  传入的密码
	 * @return
	 */
	public Employee findEmpByJobnumAndPsw(String jobnum,String password);
	/**
	 * 修改(更新)员工信息的方法
	 * @param emp 员工对象
	 * @param uid  员工的uid(主键)
	 */
	public void updateEmp(Employee emp,int uid);
	/**
	 * 修改密码
	 * @param employee
	 * @param uid
	 */
	public void updatePsw(String password,int uid);
	/**
	 * 根据员工id删除一个员工
	 * @param uid
	 */
	public void deleteEmp(int uid);
	
	
}
