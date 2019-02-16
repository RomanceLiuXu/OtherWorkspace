package com.sumi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumi.bean.Employee;
import com.sumi.bean.Role;
import com.sumi.dao.inter.RoleDao;
import com.sumi.service.inter.RoleService;

/**
 *
 * @author LiuXu
 * @time2018年8月29日下午10:18:32
 **/
@Service("roleService")
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDao roleDao;
	
	@Override
	public void addRole(Role role) {
	      roleDao.addRole(role);
	}

	@Override
	public void updateRole(Employee employee) {
		
		
	}

	@Override
	public List<Role> findRoles() {
	
		
		return roleDao.findRoles();
	}

}
