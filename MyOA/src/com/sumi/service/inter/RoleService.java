package com.sumi.service.inter;

import java.util.List;

import com.sumi.bean.Employee;
import com.sumi.bean.Role;

/**
 *
 * @author LiuXu
 * @time2018年8月29日下午10:15:16
 **/
public interface RoleService {
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
