package com.lanou.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.struts2.ServletActionContext;

/**
 *
 * @author LiuXu
 * @time2018年8月14日下午3:27:19
 **/
public class UploadAction {

	// 上传的临时文件
	private File myFile;
	// 上传的文件类型
	private String myFileContentType;
	// 上传的文件名
	private String myFileFileName;

	public String upload() throws IOException {
		System.out.println(myFile);
		String path = ServletActionContext.getServletContext().getRealPath("/");
		System.out.println(path);
		File destFile = new File(path, myFileFileName);
		// 循环读写
		FileInputStream in = new FileInputStream(myFile);
		FileOutputStream out = new FileOutputStream(destFile);
		byte[] buf = new byte[1024];
		int len = 1;
		while ((len = in.read(buf)) != -1) {
			out.write(buf, 0, len);
		}
   
	    in.close();
	    out.close();
		return "success";
	}

	public File getMyFile() {
		return myFile;
	}

	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}

	public String getMyFileContentType() {
		return myFileContentType;
	}

	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}

	public String getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}

}
