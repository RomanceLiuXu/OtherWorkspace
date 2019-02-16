package com.lanou.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
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

	@Override
	public List<Emp> findPageAll(int pageIndex, int pageNum) {
		Session session = hibernateTemplate.getSessionFactory().openSession();
		String hql = "from Emp";
		Query query = session.createQuery(hql);
		query.setFirstResult((pageIndex-1)*pageNum);
		query.setMaxResults(pageNum);
		List<Emp> emps = query.list();
		return emps;
	}

	@Override
	public long findAllNums() {
		String hql = "select count(*) from Emp";
		List<Long> alls = (List<Long>) hibernateTemplate.find(hql);
		if (alls.isEmpty()||alls.size()==0) {
			return 0;
		}else{
			return alls.get(0);
		}
	}

}
