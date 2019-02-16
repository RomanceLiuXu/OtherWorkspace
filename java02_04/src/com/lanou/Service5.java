package com.lanou;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 第三个服务器端
 * 
 * @author LiuXu
 * @time2018年7月3日下午3:40:24
 **/
public class Service5 {

	public static void main(String[] args) {

		try {
			ServerSocket ss = new ServerSocket(10003);
			System.out.println("服务器端正在监听.....");
			Socket sc = ss.accept();
			InputStream is = sc.getInputStream();
			int count = 0;
			while (count == 0) {
				count = is.available();
			}
			byte[] bs = new byte[count];
			is.read(bs);
			String res = new String(bs);

			System.out.println("接收到客户端的数据为:" + res);

			// 向客户端返回数据
			OutputStream os = sc.getOutputStream();
			String str = "收到了";
			PrintWriter pw = new PrintWriter(os, true);
			pw.println(str);
			// os.write(str.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
