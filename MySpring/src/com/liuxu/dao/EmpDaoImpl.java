package com.liuxu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.liuxu.bean.Emp;

/**
*
* @author LiuXu
* @time2018年8月23日下午7:51:28
**/
@Repository("empDao")
public class EmpDaoImpl implements EmpDao {
    @Resource
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Emp> findAll() {
		String sql = "select * from emp";
		List<Emp> emps = jdbcTemplate.query(sql, new EmpMapper());
		return emps;
	}
  class EmpMapper implements RowMapper<Emp>{
	@Override
	public Emp mapRow(ResultSet rs, int arg1) throws SQLException {
		Emp emp = new Emp();
		emp.setEid(rs.getInt("e_id"));
		emp.setEname(rs.getString("e_name"));
		emp.setEjob("e_job");
		emp.setSalary(rs.getDouble("e_sal"));
		emp.setHiredate(rs.getDate("e_hiredate"));
		return emp;
	}
	  
	  
  }
public JdbcTemplate getJdbcTemplate() {
	return jdbcTemplate;
}
public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}
  
  
}
