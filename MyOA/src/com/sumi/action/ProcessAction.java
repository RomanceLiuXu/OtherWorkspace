package com.sumi.action;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.sumi.bean.Employee;
import com.sumi.bean.myProcess;
import com.sumi.service.inter.EmployeeService;
import com.sumi.service.inter.ProcessService;

/**
 *
 * @author LiuXu
 * @time2018年8月31日下午11:23:16
 **/
@Controller("proAction")
public class ProcessAction implements SessionAware, ApplicationAware {

	@Autowired
	private ProcessService processService;
	@Autowired
	private EmployeeService employeeService;

	private Map<String, Object> session;
	private Map<String, Object> application;
	private String processName;// 流程名称
	private String processDes;// 流程描述
	private myProcess process;
	private int pageIndex;// 页码
	private int pageNum = 5;// 每页显示的条数
	private long allPage;// 总页数
	private String flag;
	private List<myProcess> processes;
	private List<Employee> employees;// 所有的管理员集合

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public String addProcess() {
		Employee employee = (Employee) application.get("emp");
		System.out.println("-------添加一条流程-----------------");
		System.out.println(processName + processDes);
		System.out.println(employee.toString());
		myProcess process = new myProcess(processName, processDes, new Date());
		processService.addProcess(employee, process);
		return "add_suc";
	}

	public String submitOrCancel() {
		System.out.println("---------------------------------------------");
		System.out.println(flag);
		System.out.println("流程id号:" + process.getId());
		System.out.println("流程级别:" + process.getProLevel());
		System.out.println("流程状态:" + process.getProStatus());
		if ("发起".equals(flag) || "提交".equals(flag)) {
			processService.submitProcess(process);
		} else {
			processService.cancelProcess(process);
		}
		return "success";
	}

	public String findProcess() {
		Employee employee = (Employee) application.get("emp");
		if (pageIndex == 0) {
			pageIndex = 1;
		}
		long allRecords = 0;
		if (employee.getRole().getRid() == 1) {
			processes = processService.findEmpProcesses(employee, pageIndex, pageNum);
			allRecords = processService.findEmpPro(employee);
			System.out.println("--个人流程记录--");
		} else {
			processes = processService.findAllProcess(employee, pageIndex, pageNum);
			allRecords = processService.findEmpsPro(employee);
			System.out.println("--全部流程记录--");
		}
		// 获取所有的管理员信息，用于初始化页面
		employees = employeeService.findAdminEmp();
		session.put("admins", employees);
		// 获取对应人员的流程信息，用于初始化页面
		session.put("processes", processes);
		allPage = allRecords % pageNum == 0 ? allRecords / pageNum : allRecords / pageNum + 1;
		System.out.println("----------------------------------------------------------------");
		System.out.println(pageIndex + ":" + allRecords+":"+allPage);
//		for (myProcess myProcess : processes) {
//			System.out.println(myProcess.getId());
//		}
		return "find_suc";
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public String getProcessDes() {
		return processDes;
	}

	public void setProcessDes(String processDes) {
		this.processDes = processDes;
	}

	public long getAllPage() {
		return allPage;
	}

	public void setAllPage(long allPage) {
		this.allPage = allPage;
	}

	public List<myProcess> getProcesses() {
		return processes;
	}

	public void setProcesses(List<myProcess> processes) {
		this.processes = processes;
	}

	public myProcess getProcess() {
		return process;
	}

	public void setProcess(myProcess process) {
		this.process = process;
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {

		this.application = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {

		this.session = arg0;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
