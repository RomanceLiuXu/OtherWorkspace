package com.lanou.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LiuXu
 * @time2018年8月24日下午2:18:29
 **/
@Repository("empDao")
public class EmpDao {
	@Resource
	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	/**
	 * 根据角色名称查询角色下所有权限
	 * 
	 * @param role
	 * @return
	 */
	public List<String> getAllPermissionByRole(String role){
	 String sql= "SELECT permission_name FROM sec_role_permission "
	 		+ "left join sec_role using(role_id) "
	 		+ "left join sec_permission using(permission_id) "
	 		+ "WHERE role_name = ?";
	List<String> premissions = jdbcTemplate.queryForList(sql,String.class,role);	
	 
		return premissions;
	}
}
