package com.sumi.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sumi.bean.Employee;
import com.sumi.bean.myProcess;
import com.sumi.dao.inter.ProcessDao;

/**
 *
 * @author LiuXu
 * @time2018年8月31日下午11:07:14
 **/
@Repository("proDao")
public class ProcessDaoImpl implements ProcessDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Override
	public void addProcess(Employee employee, myProcess process) {
		hibernateTemplate.update(employee);

	}

	@Override
	public void submitProcess(myProcess process) {
		myProcess p = hibernateTemplate.get(myProcess.class, process.getId());
	    p.setProDate(new Date());
	    if (process.getProStatus()==4) {
			p.setProStatus(1);
		}else{
			p.setProStatus(process.getProStatus() + 1);
		}
		p.setProLevel(process.getProLevel() + 1);
		hibernateTemplate.update(p);
	}

	@Override
	public void cancelProcess(myProcess process) {
		myProcess p = hibernateTemplate.get(myProcess.class, process.getId());
		if (process.getProLevel()>1) {
			p.setProStatus(4);
		}else{
			p.setProStatus(0);
		}
		p.setProLevel(1);
		hibernateTemplate.update(p);
	}

	@Override
	public List<myProcess> findEmpProcesses(Employee employee,int pageIndex,int pageNum) {
		String hql = "from myProcess where employee.uid=?";
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setInteger(0, employee.getUid());
		int start = (pageIndex - 1) * pageNum;
		query.setFirstResult(start);
		query.setMaxResults(pageNum);
		
		List<myProcess> processes = query.list();

		return processes;
	}
	
	@Override
	public long findEmpPro(Employee employee) {
		String hql = "select count(*) from myProcess where employee.uid=?";
		List<Long> num = (List<Long>) hibernateTemplate.find(hql, employee.getUid());
		if (num.isEmpty()||num.size()==0) {
			return 0;
		}
		long all = num.get(0);
		return all;
	}


	@Override
	public List<myProcess> findAllProcess(Employee employee,int pageIndex,int pageNum) {
		String hql = "from myProcess where proLevel=?";
		Session session = hibernateTemplate.getSessionFactory().openSession();
		Query query = session.createQuery(hql);
		query.setInteger(0, employee.getRole().getRid());
		int start = (pageIndex - 1) * pageNum;
		query.setFirstResult(start);
		query.setMaxResults(pageNum);
		List<myProcess> processes = query.list();

		return processes;
	}

	
	@Override
	public long findEmpsPro(Employee employee) {
		String hql = "select count(*) from myProcess where proLevel=?";
		List<Long> num = (List<Long>) hibernateTemplate.find(hql, employee.getRole().getRid());
		if (num.isEmpty()||num.size()==0) {
			return 0;
		}
		long all = num.get(0);
		return all;
	}

}
