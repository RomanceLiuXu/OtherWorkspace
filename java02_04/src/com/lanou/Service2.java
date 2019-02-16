package com.lanou;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 第二个服务器端
 * 
 * @author LiuXu
 * @time2018年7月3日下午2:07:58
 **/
public class Service2 {

	public static void main(String[] args) {

		try {
			ServerSocket ss = new ServerSocket(12222);
			System.out.println("正在监听,...");
			Socket sc = ss.accept();
			// 接收客户端传来的数据
			InputStream is = sc.getInputStream();
			// 初始化容器对象
			byte[] bs = new byte[6];
			int n = is.read(bs);
			String str = "";
			while (n != -1) {
				byte[] bs2 = new byte[n];
				for (int i = 0; i < bs2.length; i++) {
					bs2[i] = bs[i];
				}
				str += new String(bs2);
				n = is.read(bs);
			}

			// // 读数据
			// int n = -1;
			// String str = "";
			// while ((is.read(bs))!= -1) {
			// str += new String(bs);
			// }
			 System.out.println("客户端传来的数据:" + str);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
