package com.lanou.work;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 一直交流的服务端
 * 
 * @author LiuXu
 * @time2018年7月3日下午10:02:30
 **/
public class Service2 {

	public static void main(String[] args) {
		boolean isExit = false;
		// 获取对象
		ServerSocket ss = null;
		try {
			ss = new ServerSocket(12356);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		do {
			try {
//				ServerSocket ss = new ServerSocket(12356);
				
				System.out.println("服务器端正在监听....");
				// 监听
				Socket sc = ss.accept();
				// 读取数据
				InputStream is = sc.getInputStream();
				int count = 0;
				while (count == 0) {
					count = is.available();
				}
				byte[] bs = new byte[count];
				is.read(bs);
				String res = new String(bs);
				System.out.println("获取到客户端的数据为:" + res);

				// 给客户端返回数据
				PrintWriter pw = new PrintWriter(sc.getOutputStream(), true);
				String str = "收到";
				pw.println(str);

				if (res.equals("bye")) {
					isExit = true;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (!isExit);
	}

}
