package com.lanou.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.lanou.bean.Emp;
import com.lanou.service.EmpService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 *
 * @author LiuXu
 * @time2018年8月24日下午2:44:17
 **/
@Controller("empAction")
public class EmpAction extends ActionSupport implements ModelDriven<Emp> {
	
	Emp emp =null;
	@Resource
	EmpService service;

	@Override
	public Emp getModel() {
     if (emp==null) {
		emp = new Emp();
	}
		 
		return emp;
	}

	public Emp getEmp() {
		return emp;
	}

	public void setEmp(Emp emp) {
		this.emp = emp;
	}

	public EmpService getService() {
		return service;
	}

	public void setService(EmpService service) {
		this.service = service;
	}

	public String login() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		try {
			System.out.println(emp.toString());
			List<String> permissions = service.login(emp);
			if (permissions!=null) {
				session.setAttribute("msg", "登录认证成功");
				session.setAttribute("permissions", permissions);
			}
		}catch (IncorrectCredentialsException e) {
			System.out.println("登录密码错误.");
			session.setAttribute("msg", "登录密码错误");
		} catch (ExcessiveAttemptsException e) {
			System.out.println("登录失败次数过多");
			session.setAttribute("msg", "登录失败次数过多");
		} catch (LockedAccountException e) {
			System.out.println("帐号已被锁定.");
			session.setAttribute("msg", "帐号已被锁定");
		} catch (DisabledAccountException e) {
			System.out.println("帐号已被禁用. ");
			session.setAttribute("msg", "帐号已被禁用");
		} catch (ExpiredCredentialsException e) {
			System.out.println("帐号已过期. ");
			session.setAttribute("msg", "帐号已过期");
		} catch (UnknownAccountException e) {
			System.out.println("帐号不存在.");
			session.setAttribute("msg", "帐号不存在");
		} catch (UnauthorizedException e) {
			System.out.println("您没有得到相应的授权！" + e.getMessage());
			session.setAttribute("msg", "您没有得到相应的授权！");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return SUCCESS;
	}
	
}
