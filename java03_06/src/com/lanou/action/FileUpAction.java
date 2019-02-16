package com.lanou.action;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

/**
 * 头像上传
 * 
 * @author LiuXu
 * @time2018年8月2日下午8:36:36
 **/
public class FileUpAction {

	private File file;
	private String fileFileName;
	private String basePath;

	public String fileUp() throws IOException {
		// 获取路径
		String path = ServletActionContext.getServletContext().getRealPath("img");
		if (file==null) {
			return "error";
		}
		FileUtils.copyFile(file, new File(path + "/" + fileFileName));
		HttpServletRequest request = ServletActionContext.getRequest();
		// HttpSession session = request.getSession();
		// 公共路径
		basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
				+ request.getContextPath() + "/img/" + fileFileName;
		// System.out.println("--"+path);
		// //--/Users/xalo/Library/tomcat/wtpwebapps/java03_06/img
		System.out.println("--" + basePath);// http://localhost:8080/java03_06/
		// session.setAttribute("address", basePath);
		
		return "success";
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

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

}
