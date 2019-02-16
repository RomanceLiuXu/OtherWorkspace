package com.lanou.work;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.util.Scanner;

import javax.swing.text.IconView;

/**
 * 一直交流的客户端
 * 
 * @author LiuXu
 * @time2018年7月3日下午10:02:43
 **/
public class Client2 {

	public static void main(String[] args) {

		boolean isExit = false;
		// 获取对象
		Socket sc = null;
		try {
			sc = new Socket("127.0.0.1", 12356);
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		do {
			try {
//				Socket sc = new Socket("127.0.0.1", 12356);
				// 准备发送的数据
				System.out.println("请输入向服务器发送的数据:");
				Scanner scanner = new Scanner(System.in);
				String str = scanner.next();

				PrintWriter pw = new PrintWriter(sc.getOutputStream(), true);
				pw.println(str);

				// 接收服务器返回的数据
				InputStream is = sc.getInputStream();
				int count = 0;
				while (count == 0) {
					count = is.available();
				}
				byte[] bs = new byte[count];
				is.read(bs);
				String res = new String(bs);
				System.out.println("获取服务器返回的数据为:" + res);
				if (res.equals("bye")) {
					isExit = true;
				}
			} catch (UnknownHostException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while (!isExit);
	}

}
