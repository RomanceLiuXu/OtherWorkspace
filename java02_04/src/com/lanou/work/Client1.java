package com.lanou.work;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 作业 客户端
 * 
 * @author LiuXu
 * @time2018年7月3日下午8:08:21
 **/
public class Client1 {

	public static void main(String[] args) {

		try {
			// 获取对象
			Socket sc = new Socket("127.0.0.1", 12001);
			// 获取输出流对象
			OutputStream os = sc.getOutputStream();
			// 准备写入的数据
			System.out.println("请输入向服务器发送的数据:");
			Scanner sca = new Scanner(System.in);
			String scStr = sca.next();
			// 写入数据
			PrintWriter pw = new PrintWriter(os, true);
			pw.println(scStr);

			// 接收服务返回的数据
			InputStream is = sc.getInputStream();
			int count = 0;
			while (count == 0) {
				count = is.available();
			}
			byte[] bs = new byte[count];
			// 读取数据
			is.read(bs);
			String res = new String(bs);
			System.out.println("接收从服务端返回的数据为:" + res);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
