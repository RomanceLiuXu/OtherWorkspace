package com.sumi.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sumi.bean.Employee;
import com.sumi.bean.Role;
import com.sumi.dao.inter.RoleDao;

/**
 *
 * @author LiuXu
 * @time2018年8月29日下午10:17:06
 **/
@Repository("roleDao")
public class RoleDaoImpl implements RoleDao{

	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Override
	public void addRole(Role role) {
		hibernateTemplate.save(role);
	}

	@Override
	public void updateRole(Employee employee) {
		
		
	}

	@Override
	public List<Role> findRoles() {
		String hql = "from Role";
		List<Role> roles = (List<Role>) hibernateTemplate.find(hql);
		
		return roles;
	}

	
}
