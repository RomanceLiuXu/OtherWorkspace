package com.match.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.google.gson.JsonObject;
import com.match.service.FileUpServiceE;

/**
 * 获取注册界面传来的用户id和上传图片的信息
 * 
 * @author LiuXu
 * @time2018年7月10日下午2:03:29
 **/
public class FileUpServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// // // 获取注册界面传来的用户id
		// String uids = req.getParameter("uid");
		// int uid = Integer.parseInt(uids);
		// System.out.println(uid);
		// int uid = 10;
		// 添加头部信息
		res.addHeader("Access-Control-Allow-Origin", "*");
		// 设置编码格式：
		res.setContentType("text/html;charset=utf8");

		// 确定上传的路径
		String path = this.getServletContext().getRealPath("marry");
		System.out.println(path);

		File file = new File(path);
		// 判断文件夹是否存在,不存在则创建
		if (!file.exists() && !file.isDirectory()) {
			// 不存在则创建
			file.mkdirs();
		}
		String filename = file.getName();
		System.out.println("文件夹名:" + filename);

		// 使用servlet上传文件的步骤:
		// 1.实例化DiskFileItemFactory对象
		DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
		// 2.实例化ServletFileUpload对象
		ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
		int uid = 0;
		String pname = "";
		String paddress = "";
		// 3.使用upload对象获取req中存在的所有的fileItem
		try {
			List<FileItem> fileItems = upload.parseRequest(req);
			// 4.遍历
			for (FileItem fileItem : fileItems) {
				// 判断文件名是否存在，不存在则不管
				if (fileItem.getFieldName() == null || fileItem.getFieldName().equals("")) {
					continue;
				}
				// 调用service层
				FileUpServiceE fileService = new FileUpServiceE();
				if (fileItem.getFieldName().equals("uuid")) {
					String uids = fileItem.getString();
					uid = Integer.parseInt(uids);
					System.out.println(uids);
				} else {
					System.out.println(fileItem.getFieldName());
					// 获取文件名（图片的名称，需要存入数据库）
					pname = fileItem.getName();

					System.out.println("图片的名称:" + pname);
					// 获取输入流对象
					InputStream is = fileItem.getInputStream();
					// 输出流对象
					FileOutputStream os = new FileOutputStream(path + "//" + pname);
					// 创建容器
					byte[] bytes = new byte[1024];
					int n = 0;
					while ((n = is.read(bytes)) != -1) {
						// 循环读并写入
						os.write(bytes, 0, n);
					}
					// 关闭
					is.close();
					os.close();
					// 统一的路径（图片的前缀路径）
					// paddress = req.getScheme() + "://" + req.getServerName()
					// + ":" + req.getServerPort()
					// + req.getContextPath() + "/" + filename + "/";
					// System.out.println("前缀路径:" + paddress);
					paddress = filename + "/" + pname;
				}
				// 上传成功之后将用户id和图片的名称、路径加到数据库中
				// 是否添加成功
				System.out.println("图片最终路径:" + paddress);
				if (uid != 0) {
					boolean isAdd = fileService.addPicture(uid, pname, paddress);
					//编码
					paddress = URLEncoder.encode(paddress, "UTF-8");
					//解码
					paddress = URLDecoder.decode(paddress, "ISO-8859-1");
					res.sendRedirect("photoupsuccess.html?paddress=" + paddress);
					break;
				}

			}
		} catch (FileUploadException e) {

			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.doGet(req, resp);
	}

}
