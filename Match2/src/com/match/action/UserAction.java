package com.match.action;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.match.beans.User;
import com.match.beans.UserP;
import com.match.beans.UserPp;
import com.match.service.HomeServiceE;
import com.match.service.LoginServiceE;
import com.match.service.SelectService;
import com.opensymphony.xwork2.util.ResolverUtil.IsA;

/**
 * 用户action
 * 
 * @author LiuXu
 * @time2018年8月3日下午7:22:45
 **/
public class UserAction {

	private String name;// 姓名
	private String psw;// 密码
	private UserP userP;// 用户对象
	private List<UserPp> list;//匹配人员的集合
	private int uid;

	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();

	// 登录的action
	public String login() {
		// 调用方法
		LoginServiceE serviceE = new LoginServiceE();
	 	userP = serviceE.userLogin(name, psw);
		System.out.println("登录信息:" + userP);
		if (userP != null) {
			session.setAttribute("userP", userP);
			// System.out.println("userP:" + userP.toString());
		}
		return "success";
	}

	// 登录后显示所有用户信息的action（可利用缓存机制）
	public String initHome() {
		ServletContext application = request.getServletContext();
		UserP userP1 = (UserP) session.getAttribute("userP");
		if (userP1 != null) {
			System.out.println("-------");
			HomeServiceE homeServiceE = new HomeServiceE();
			String sex1 = "";
			if (userP1.getSex().equals("男")) {
				sex1 = "女";
			} else {
				sex1 = "男";
			}
			List<UserP> lists = homeServiceE.findAll(sex1);
			application.setAttribute("lists", lists);
			// System.out.println("人员集合:"+lists);
			if (lists != null) {
				return "success";
			}
		}

		return "error";
	}

	// 首页人员详细信息的action
    public String personal() {
		SelectService selectService = new SelectService();
	    userP = selectService.perMethod(uid);
	    System.out.println("点击人员:"+userP);
    	if (userP!=null) {
    		return "personal";
		}
    	
    	return "home";
	}
	
	
	// 同城匹配的action
	public String select() {
		UserP userP1 = (UserP) session.getAttribute("userP");
		SelectService select = new SelectService();
		// System.out.println("select中的user:" + userP1.toString());
		// 获取登录人员的信息，查找匹配的人员
		if (userP1 != null) {
			list = select.selectMethod(userP1.getUid(), userP1.getAge(), userP1.getSex(),
					userP1.getAddress().substring(0, 2));
			// System.out.println("list的值:" + list.toString());
		}

		return "select";
	}

	// 异成匹配的acion
	public String select2() {
		UserP userP1 = (UserP) session.getAttribute("userP");
		SelectService select = new SelectService();
		// 获取登录人员的信息，查找匹配的人员
		if (userP1 != null) {
			list = select.selectMethod(userP1.getUid(), userP1.getAge(), userP1.getSex(),
					userP1.getAddress().substring(0, 2));

		}
		return "select2";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPsw() {
		return psw;
	}

	public void setPsw(String psw) {
		this.psw = psw;
	}

	public UserP getUserP() {
		return userP;
	}

	public void setUserP(UserP userP) {
		this.userP = userP;
	}

	public List<UserPp> getList() {
		return list;
	}

	public void setList(List<UserPp> list) {
		this.list = list;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

}
