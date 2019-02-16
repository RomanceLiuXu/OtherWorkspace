package com.sumi.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sumi.bean.Attendance;
import com.sumi.bean.Employee;
import com.sumi.dao.inter.AttendDao;
import com.sumi.service.inter.AttendService;

/**
 *
 * @author LiuXu
 * @time2018年8月30日上午11:02:39
 **/
@Service("attendService")
public class AttendServiceImpl implements AttendService{
    @Autowired
	private AttendDao attendDao;
	@Override
	public List<Attendance> findEmpAttend(Employee employee) {
		
		return attendDao.findEmpAttend(employee);
	}

	@Override
	public List<Attendance> findAllEmpsAttend() {
		
		return attendDao.findAllEmpsAttend();
	}

	@Override
	public long findDayAttend(Employee employee) {
		
		return attendDao.findDayAttend(employee);
	}

	@Override
	public void saveEmpAttend(Employee employee) {	
		
		attendDao.saveEmpAttend(employee);
	}

}
