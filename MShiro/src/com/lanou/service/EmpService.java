package com.lanou.service;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import com.lanou.bean.Emp;
import com.lanou.dao.EmpDao;

/**
 *
 * @author LiuXu
 * @time2018年8月24日下午2:25:21
 **/
@Service("empService")
public class EmpService {
	@Resource
	EmpDao empDao;

	public EmpDao getEmpDao() {
		return empDao;
	}

	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}

	/**
	 * 用户登录
	 * 
	 * @param emp
	 * @return
	 */
	public List<String> login(Emp emp) throws Exception{
		// 使用init配置文件获取SecurityManager对象
		Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
		// 获取SecurityManager对象
		SecurityManager sm = factory.getInstance();
		// 装配到SecurityUtils中
		SecurityUtils.setSecurityManager(sm);
		// 通过SecurityUtils获取subject对象
		Subject subject = SecurityUtils.getSubject();
		// 封装用户信息
		UsernamePasswordToken token = new UsernamePasswordToken(emp.getUsername(), emp.getPassword());

		// 执行登录操作,如果登录失败则抛出不同的异常
		subject.login(token);


		// 权限
		// subject.checkRole("admin");
		// 使用shiro框架的hasrole方法判断用户是否具有某角色
		boolean isTrue = subject.hasRole("admin");
		if (isTrue) {
			List<String> permissions = empDao.getAllPermissionByRole("admin");
			return permissions;
		}

		return null;
	}

}
