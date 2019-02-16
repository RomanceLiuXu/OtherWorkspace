package com.sumi.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.miaodiyun.httpApiDemo.IndustrySMS;
import com.sumi.bean.Department;
import com.sumi.bean.Employee;
import com.sumi.service.inter.DeptService;
import com.sumi.service.inter.EmployeeService;
import com.sumi.util.RandomCode;
import com.sumi.util.Sheet;

/**
 *
 * @author LiuXu
 * @time2018年8月28日下午8:53:08
 **/
@Controller("employeeAction")
public class EmployeeAction implements SessionAware, ApplicationAware {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private DeptService deptService;
	private int pageIndex;// 页码
	private long allPage;// 总页数
	private List<Employee> employees;
	int pageNum = 3;// 每页显示的个数
	private String dname;// 查询的部门
	private String uname;// 查询的人员姓名
	private Map<String, Object> session;
	private Map<String, Object> application;
	// 完善个人信息
	private String phone;// 手机号
	private Employee emp;
	private String phoneValidate;// 前端传来的手机验证码
	private List<Department> departments;
	private int uid;// 根据uid删除员工
	private String msg;//
	private Employee employee;// 新增的员工

	// 新增一个员工
	public String addNewEmp() {
		// 通过部门名称查找部门对象
		Department department = deptService.findDeptByName(dname);
		System.out.println("-----------------------------------------------");
		System.out.println(employee.getJobnum() + ":" + employee.getUname());

		// 调用方法添加
		employeeService.addNewEmp(department, employee);

		return "success";
	}

	// 分页查询的方法
	public String pageEmployee() {
		if (pageIndex == 0) {
			this.pageIndex = 1;
		}
		System.out.println("uname:" + uname + "---dname:" + dname);
		// 总的记录条数
		long all = 0;
		if (!IsNull(dname) && !IsNull(uname)) {
			// 查询总页数
			all = employeeService.findAllPage();
			employees = employeeService.findEmployees(pageIndex, pageNum);
			this.allPage = all % pageNum == 0 ? all / pageNum : all / pageNum + 1;
			System.out.println("----总人数分页---");
		} else {
			if (IsNull(dname) && !IsNull(uname)) {
				// 按部门名称查询总页数
				all = employeeService.findAllPage(dname);
				// 按部门名称分页查询员工信息
				employees = employeeService.findDeptEmps(dname, pageIndex, pageNum);
				System.out.println("---部门分页---");
				this.allPage = all % pageNum == 0 ? all / pageNum : all / pageNum + 1;
			} else if (IsNull(dname) && IsNull(uname) && !dname.equals("0")) {
				// 按照部门和名称查询
				employees = employeeService.findEmpsByDeptAndName(dname, uname);
				allPage = 1;
				System.out.println("-部门和人名-");
			} else {
				// 按照人名查询
				employees = employeeService.findEmpsByName(uname);
				allPage = 1;
				System.out.println("-人名-");
			}
		}
		return "success";
	}

	public boolean IsNull(String str) {
		if (str == null || "".equals(str)) {
			return false;
		}
		return true;
	}

	/**
	 * 登录
	 * 
	 * @return
	 */
	public String loginCheck() {
		System.out.println("登录时前端传来的值：" + emp.getJobnum() + "--" + emp.getPassword());
		// 定义个字符串数组，用来存储需要判空的属性
		String[] strs = { emp.getJobnum(), emp.getPassword() };
		if (nullCheck(strs)) {
			// 调用登录验证的方法
			emp = employeeService.findEmpByJobnumAndPsw(emp.getJobnum(), emp.getPassword());
		}
		if (emp != null) {
			// 不为空，登录成功
			// 将工号对象存储到容器中，以便前端获取
			application.put("emp", emp);
			return "success";
		}
		// 登录失败
		return "error";
	}

	/**
	 * 发送短信验证码
	 * 
	 * @return
	 */
	public String phoneCheck() {
		System.out.println("前端传来的手机号码为：" + phone);
		// 调用方法获取随机验证码
		String randomCode = RandomCode.randomStr();
		// 将获取的随机验证码存储到容器中
		session.put("randomCode", randomCode);
		System.out.println(randomCode);
		// 此处调用发送短信的方法 IndustrySMS.execute(手机号,验证码);
		IndustrySMS.execute("15102905231", randomCode);
		return "success";
	}

	// 更新个人信息
	public String updateEmp() {
		// 获取登录时容器中存储的员工的uid
		int uid = ((Employee) application.get("emp")).getUid();
		// 获取容器中存储的随机码
		String randomCode = (String) session.get("randomCode");
		if (phoneValidate.equalsIgnoreCase(randomCode)) {
			// 验证码一致
			// 调用service修改员工信息的方法
			employeeService.updateEmp(emp, uid);
			return "success";
		}
		return "error";
	}

	// 根据工号和密码查找对应的员工对象
	public String findEmp() {
		// 获取登录时容器中存储的员工对象
		Employee employee = (Employee) application.get("emp");
		// 根据工号和密码查找员工
		emp = employeeService.findEmpByJobnumAndPsw(employee.getJobnum(), employee.getPassword());
		return "success";
	}

	// 修改密码
	public String updatePsw() {
		// 获取登录时容器中存储的员工对象
		Employee employee = (Employee) application.get("emp");
		System.out.println("修改密码时：新密码为：" + emp.getPassword() + "容器中存储的员工id为：" + employee.getUid());
		employeeService.updatePsw(emp.getPassword(), employee.getUid());
		return "success";
	}

	// 通讯录(按部门)
	public String findMessage() {
		departments = deptService.findDepartments();
		System.out.println("findMessage()中，前端传来的名称为：" + dname);
		if (pageIndex == 0) {
			pageIndex = 1;
		}
		long rows = employeeService.findAllPage(dname);
		allPage = rows % pageNum == 0 ? rows / pageNum : rows / pageNum + 1;
		System.out.println("总页数为：" + allPage);
		employees = employeeService.findDeptEmps(dname, pageIndex, pageNum);
		String path = ServletActionContext.getServletContext().getRealPath("/") + "phone.xls";
		Sheet.getSheet(employees, dname, path);
		return "success";
	}

	// 通过姓名查员工对象(没分页)
	public String findEmpsByName() {
		System.out.println("findEmpsByName():" + emp.getUname());
		employees = employeeService.findEmpsByName(emp.getUname());
		departments = deptService.findDepartments();
		return "success";
	}

	// 根据员工id删除一个员工
	public String deleteEmp() {
		System.out.println("删除时前端出来的uid为：" + uid);
		if (uid > 0) {
			employeeService.deleteEmp(uid);
			msg = "success";
			return "success";
		}
		msg = "default";
		return "success";
	}

	/**
	 * 判空的方法
	 * 
	 * @param strs
	 *            传入的数组
	 * @return
	 */
	public boolean nullCheck(String[] strs) {
		for (String str : strs) {
			if (str == null || "".equals(str)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public String getPhoneValidate() {
		return phoneValidate;
	}

	public void setPhoneValidate(String phoneValidate) {
		this.phoneValidate = phoneValidate;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public long getAllPage() {
		return allPage;
	}

	public void setAllPage(long allPage) {
		this.allPage = allPage;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public List<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}

}
