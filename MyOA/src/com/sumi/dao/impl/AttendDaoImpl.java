package com.sumi.dao.impl;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.sumi.bean.Attendance;
import com.sumi.bean.Employee;
import com.sumi.dao.inter.AttendDao;

/**
 *
 * @author LiuXu
 * @time2018年8月30日上午10:44:53
 **/
@Repository("attendDao")
public class AttendDaoImpl implements AttendDao {

	@Autowired
	HibernateTemplate hibernateTemplate;

	@Override
	public List<Attendance> findEmpAttend(Employee employee) {
		String hql = "from Attendance where jobnum=?";
		List<Attendance> records = (List<Attendance>) hibernateTemplate.find(hql, employee.getJobnum());
		return records;
	}

	@Override
	public List<Attendance> findAllEmpsAttend() {
		String hql = "from Attendance";
		List<Attendance> records = (List<Attendance>) hibernateTemplate.find(hql);
		return records;
	}

	@Override
	public long findDayAttend(Employee employee) {
		long n = 0;
		String hql = "from Attendance where jobnum=?";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String today = sdf.format(new Date());
		List<Attendance> records = (List<Attendance>) hibernateTemplate.find(hql, employee.getJobnum());
		if (records.isEmpty() || records.size() == 0) {
			return n;
		}
		for (Attendance attendance : records) {
			if (sdf.format(attendance.getCreateTime()).equals(today)) {
				n++;
			}
		}
		return n;
	}

	@Override
	public void saveEmpAttend(Employee employee) {

//		Date nowdate = new Date();
//		// 转换时间格式
//		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Attendance attendance = new Attendance();
		attendance.setEmployee(employee);
		attendance.setJobnum(employee.getJobnum());
		attendance.setCreateTime(new Date());
		employee.getAttendances().add(attendance);
		hibernateTemplate.update(employee);
	}

}
