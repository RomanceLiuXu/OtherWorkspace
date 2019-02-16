package com.sumi.dao.inter;

import java.util.List;

import com.sumi.bean.Department;
import com.sumi.bean.Employee;
import com.sumi.bean.Role;

/**
 * 部门操作的接口
 * 
 * @author LiuXu
 * @time2018年8月28日下午10:39:32
 **/
public interface DeptDao {

	/**
	 * 新增部门，管理者有此权限
	 */
	public void addDepartment(Department department);
	
	/**
	 * 删除部门，管理者有此权限
	 */
	public void deleteDepartment(Department department);
	
	/**
	 * 查询所有的部门信息
	 */
    public List<Department> findDepartments();
    
  /**
   * 修改员工的部门
   * @param did   新的部门编号
   * @param uid   要修改员工的id
   */
    public void updateEmpDept(Department department,int uid);
    
    
    /**
     * 修改员工的权限
     * @param rid  对应的权限对象id
     * @param uid 要修改的员工id
     */
    public void updateEmpRole(int rid,int uid);
    
    /***********************************************************************/
    /**
   	 * 根据部门名称查找部门对象
   	 * @param dname
   	 * @return
   	 */
   	public Department findDeptByName(String dname);
   	
   	/**
   	 * 更新部门信息
   	 * @param department
   	 */
   	public Department updateDept(Department department);
	
}
