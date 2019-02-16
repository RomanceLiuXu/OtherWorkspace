package com.match.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.match.beans.User;
import com.match.service.FileUpServiceE;
import com.match.service.RegisterServiceE;

/**
 * 注册的action
 * 
 * @author LiuXu
 * @time2018年8月5日下午1:15:21
 **/
public class RegisterAction {

	private User user;
	private String province;
	private String city;
	private File file;
	private String fileFileName;
	private String paddress;

	HttpSession session = ServletActionContext.getRequest().getSession();

	// 注册
	public String register() {
		// 实例化
		RegisterServiceE regservicee = new RegisterServiceE();
		// System.out.println("action:" + user.toString() + "--" + province +
		// city);
		user.setAddress(province + city);
		int n = regservicee.addMethod(user);
		if (n > 0) {
			session.setAttribute("nid", n);
			return "success";
		}

		return "error";
	}

	// 上传头像
	public String photoUp() throws IOException {
		// System.out.println(file + "--" + fileFileName + session);
		int uid = (int) session.getAttribute("nid");
		FileUpServiceE fileup = new FileUpServiceE();
		// 新建上传路径
		String path = ServletActionContext.getServletContext().getRealPath("marry");
		FileUtils.copyFile(file, new File(path + "//" + fileFileName));
		paddress = "marry/" + fileFileName;
		// System.out.println("--" + paddress);
		boolean addPicture = fileup.addPicture(uid, fileFileName, paddress);
		if (addPicture) {
			return "upok";
		}
		return "upfalse";
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getPaddress() {
		return paddress;
	}

	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}

}
