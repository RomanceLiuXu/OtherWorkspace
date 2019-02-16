package com.lanou;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author LiuXu
 * @time2018年8月2日上午11:00:03
 **/
public class Demo2Action {

	private File file;
	private String fileFileName;
	private String fileContentType;

	public String method1() throws IOException {
		// System.out.println(file);
		// System.out.println(fileFileName);
		// System.out.println(fileContentType);
		// // HttpServletRequest request = ServletActionContext.getRequest();
		// // 获取路径
		 String path = ServletActionContext.getServletContext().getRealPath("myimg");
		// System.out.println(path);
		// // 创建文件夹
		// File mfile = new File(path);
		// // 判断文件夹是否存在,不存在则创建
		// if (!mfile.exists() && !mfile.isDirectory()) {
		// // 不存在则创建
		// mfile.mkdirs();
		// }
		// try {
		// // 输入流
		// FileInputStream is = new FileInputStream(file);
		// // 输出流
		// FileOutputStream os = new FileOutputStream(path + "//" +
		// fileFileName);
		// // 创建容器
		// byte[] bytes = new byte[1024];
		// int n = 0;
		// while ((n = is.read(bytes)) != -1) {
		// // 循环读并写入
		// os.write(bytes, 0, n);
		// }
		// // 关闭
		// is.close();
		// os.close();
		// } catch (FileNotFoundException e) {
		// e.printStackTrace();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		// struts2中上传文件
		 FileUtils.copyFile(file, new File(path + "//" + fileFileName));

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

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

}
