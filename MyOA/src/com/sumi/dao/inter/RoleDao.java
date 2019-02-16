package com.sumi.dao.inter;

import java.util.List;

import com.sumi.bean.Employee;
import com.sumi.bean.Role;

/**
 * 权限操作的接口
 * @author LiuXu
 * @time2018年8月29日下午9:21:35
 **/
public interface RoleDao {

//	添加权限  修改权限  查询权限
	
	/**
	 * 添加权限
	 */
   public void addRole(Role role);
   
   /**
    * 修改权限
    */
   public void updateRole(Employee employee);
   
   /**
    * 查询数据库所有的权限
    * @return
    */
   public List<Role> findRoles();
	
}
