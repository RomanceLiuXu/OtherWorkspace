package com.lanou.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.lanou.bean.Emp;

/**
 *
 * @author LiuXu
 * @time2018年8月23日上午10:12:26
 **/
@Repository("empDao")
public class EmpDaoImpl implements EmpDao {

	// ** 用于操作数据库对象 */
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
			emp.setId(rs.getInt("e_id"));
			emp.setName(rs.getString("e_name"));
			emp.setJob(rs.getString("e_job"));
			emp.setSalary(rs.getDouble("e_sal"));
			emp.setHiredate(rs.getDate("e_hiredate"));
			return emp;
		}
		
	}
	
	@Override
	public Emp findEmpById(int id) {
		String sql = "select * from emp where e_id=?";
		Emp emp = jdbcTemplate.queryForObject(sql, new EmpMapper(), id);
		return emp;
	}

	@Override
	public void deleteEmpById(int id) {
		String sql = "delete from emp where e_id=?";
		jdbcTemplate.update(sql, id);

	}

	@Override
	public void save(Emp emp) {
	 String sql = "insert into emp values(0,?,?,?,?)";
     jdbcTemplate.update(sql, emp.getName(),emp.getJob(),emp.getSalary(),emp.getHiredate());
	}

	@Override
	public void update(Emp emp) {
	 String sql = "update emp set e_name=?,e_job=?,e_sal=?,e_hiredate=? where e_id=?";
     jdbcTemplate.update(sql, emp.getName(),emp.getJob(),emp.getSalary(),emp.getHiredate(),emp.getId());
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
