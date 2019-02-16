package com.sumi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumi.bean.Employee;
import com.sumi.bean.myProcess;
import com.sumi.dao.inter.ProcessDao;
import com.sumi.service.inter.ProcessService;

/**
 *
 * @author LiuXu
 * @time2018年8月31日下午11:11:47
 **/
@Service("proService")
public class ProcessServiceImpl implements ProcessService{

	@Autowired
	private ProcessDao processDao;
	@Override
	public void addProcess(Employee employee, myProcess process) {
	 process.setEmployee(employee);
	 process.setProLevel(1);
	 employee.getProcesses().add(process);
	 processDao.addProcess(employee, process);
	}
	@Override
	public void submitProcess(myProcess process) {
		
		processDao.submitProcess(process);
	}
	@Override
	public void cancelProcess(myProcess process) {
		processDao.cancelProcess(process);
	}
	@Override
	public List<myProcess> findEmpProcesses(Employee employee,int pageIndex,int pageNum) {
		
		return processDao.findEmpProcesses(employee,pageIndex,pageNum);
	}
	@Override
	public List<myProcess> findAllProcess(Employee employee,int pageIndex,int pageNum) {
		
		return processDao.findAllProcess(employee,pageIndex,pageNum);
	}
	@Override
	public long findEmpPro(Employee employee) {
		
		return processDao.findEmpPro(employee);
	}
	@Override
	public long findEmpsPro(Employee employee) {
		
		return processDao.findEmpsPro(employee);
	}
	
	
	
	

}
