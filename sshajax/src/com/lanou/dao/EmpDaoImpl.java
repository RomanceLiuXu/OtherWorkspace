package com.lanou.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.lanou.bean.Emp;

/**
 *
 * @author LiuXu
 * @time2018年9月9日下午2:23:23
 **/
@Repository("empDao")
public class EmpDaoImpl implements EmpDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public List<Emp> findAll() {
      String hql="from Emp";
      List<Emp> emps = (List<Emp>) hibernateTemplate.find(hql);
		return emps;
	}

	@Override
	public void addEmp(Emp emp) {
		hibernateTemplate.save(emp);
		
	}

	@Override
	public Emp findEmpById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmpById(int id) {
      hibernateTemplate.delete(hibernateTemplate.get(Emp.class, id));		
	}

	@Override
	public void updateEmp(Emp emp) {
		hibernateTemplate.update(emp);
	}

	@Override
	public Emp findEmpByName(String uname) {
		String hql = "from Emp where uname=?";
		List<Emp> emps = (List<Emp>) hibernateTemplate.find(hql, uname);
		if (emps.isEmpty()||emps.size()==0) {
			return null;
		}
		
		return emps.get(0);
	}

}
