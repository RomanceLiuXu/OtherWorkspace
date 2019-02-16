package com.sumi.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sumi.bean.Attendance;
import com.sumi.bean.Employee;
import com.sumi.service.inter.AttendService;

/**
 * 打卡的action
 * 
 * @author LiuXu
 * @time2018年8月30日上午11:16:18
 **/
@Controller("attendAction")
public class AttendAction implements SessionAware, ApplicationAware {

	@Autowired
	private AttendService attendService;

	private Employee employee;
	private Map<String, Object> session;
	private Map<String, Object> application;
	private List<Attendance> records;
	private long num;

	public long getNum() {
		return num;
	}

	public void setNum(long num) {
		this.num = num;
	}

	public String checkAttend() {
		employee = (Employee) application.get("emp");
		this.num = attendService.findDayAttend(employee);
		return "check_suc";
	}

	public String addAttend() {
		 employee = (Employee) application.get("emp");
         attendService.saveEmpAttend(employee);
		return "success";
	}

	public String findSignleAttend() {
		employee = (Employee) application.get("emp");
		records = attendService.findEmpAttend(employee);
		session.put("records", records);
		return "success";
	}

	public String findAllAttend() {
		records = attendService.findAllEmpsAttend();
		session.put("records", records);
		return "success";
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

	public List<Attendance> getRecords() {
		return records;
	}

	public void setRecords(List<Attendance> records) {
		this.records = records;
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		this.application = arg0;

	}

}
