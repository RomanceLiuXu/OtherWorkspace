package com.sumi.dao.inter;

import java.util.List;

import com.sumi.bean.Attendance;
import com.sumi.bean.Employee;

/**
 * 考勤操作
 * 
 * @author LiuXu
 * @time2018年8月30日上午10:37:30
 **/
public interface AttendDao {

	// 某个员工打卡的方法
	public void saveEmpAttend(Employee employee);

	// 查询某个员工的打卡记录
	public List<Attendance> findEmpAttend(Employee employee);

	// 查询所有员工的打卡记录
	public List<Attendance> findAllEmpsAttend();

	// 查询某个员工今日打卡的次数
	public long findDayAttend(Employee employee);
}
