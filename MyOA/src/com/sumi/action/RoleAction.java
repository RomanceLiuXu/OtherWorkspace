package com.sumi.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sumi.bean.Role;
import com.sumi.service.inter.RoleService;

/**
 * 操作权限的action
 * 
 * @author LiuXu
 * @time2018年8月29日下午11:03:34
 **/
@Controller("roleAction")
public class RoleAction implements SessionAware{

	@Autowired
	private RoleService roleService;

	private Map<String, Object> session;
	private Role role;// 权限
	private List<Role> roles;// 所有权限的集合

	public String addRole() {
		System.out.println(role.getRid()+"---"+role.getRname());
		roleService.addRole(role);
		return "add_suc";
	}

	public String findRoles() {
		roles = roleService.findRoles();
		session.put("roles", roles);
		System.out.println("---所有角色--");
		for (Role role : roles) {
			System.out.println(role.getRname());
		}
		return "find_suc";
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
	
		this.session = arg0;
	}

}
