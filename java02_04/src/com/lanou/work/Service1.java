package com.lanou.work;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 作业 服务器端
 * 
 * @author LiuXu
 * @time2018年7月3日下午8:08:03
 **/
public class Service1 {

	public static void main(String[] args) {

		try {
			// 获取对象
			ServerSocket ss = new ServerSocket(12001);
			// 提示
			System.out.println("服务器端正在监测....");
			// 监测
			Socket st = ss.accept();
			// 获取客户端传来的数据
			InputStream is = st.getInputStream();
			// 读取数据
			int count = 0;
			while (count == 0) {
				count = is.available();
			}
			byte[] bs = new byte[count];
			is.read(bs);
			String str = new String(bs);
			System.out.println("接收客户端的数据为:" + str);

			// 向客户端返回数据
			OutputStream os = st.getOutputStream();
			// 准备返回的数据
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入返回客户端的消息:");
			String re = scanner.next();
			// 写入数据
			PrintWriter pw = new PrintWriter(os, true);
			pw.println(re);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
