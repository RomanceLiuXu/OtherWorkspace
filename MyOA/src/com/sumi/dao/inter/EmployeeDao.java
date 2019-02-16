package com.sumi.dao.inter;

import java.util.List;

import com.sumi.bean.Department;
import com.sumi.bean.Employee;

/**
 *
 * @author LiuXu
 * @time2018年8月28日下午4:58:01
 **/
public interface EmployeeDao {

	/**
	 * 
	 * @param pageIndex
	 *            页码
	 * @param pageNum
	 *            每页显示的个数
	 * @return 查询的人员集合
	 */
	public List<Employee> pageEmployee(int pageIndex, int pageNum);

	/**
	 * 根据部门名称查找所有对应的员工
	 * 
	 * @param dname
	 * @return
	 */
	public List<Employee> DeptEmployees(String dname, int pageIndex, int pageNum);

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
	 * 
	 * @param pageNum
	 *            每页显示的个数
	 * @return
	 */
	public long allPage();

	/**
	 * 查询总页数
	 * 
	 * @param pageNum
	 *            每页显示的个数
	 * @return
	 */
	public long allPage(String dname);
	
    /**
     * 给部门新增员工的方法
     * @param department
     * @param employee
     */
	public void addNewEmp(Department department,Employee employee);
	
	/**
	 * 查找所有管理员(admin)
	 * @return
	 */
	public List<Employee> findAdminEmp();
	
	
	
	
/***************************************************************************************/
	
	/**
	 * 根据工号和密码查找一个员工对象
	 * @param jobnum
	 * @param password
	 * @return
	 */
	public Employee findEmpByJobnumAndPsw(String jobnum,String password);
	/**
	 * 更新个人信息的方法
	 * 相当于是通过员工的uid去修改员工的信息
	 * @param emp 传来的存储员工信息的对象
	 * @param uid   员工的uid
	 */
	public void updateEmp(Employee emp,int uid);
	/**
	 * 修改密码
	 * @param password
	 * @param uid
	 */
	public void updatePsw(String password,int uid);
	/**
	 * 删除一个员工
	 * @param employee
	 */
	public void deleteEmp(int uid);
	
	
}
