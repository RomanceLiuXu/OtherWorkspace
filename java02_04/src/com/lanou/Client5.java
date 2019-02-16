package com.lanou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 第三个客户端
 * 
 * @author LiuXu
 * @time2018年7月3日下午3:40:36
 **/
public class Client5 {

	public static void main(String[] args) {

		try {
			// 获取连接
			Socket sc = new Socket("127.0.0.1", 10003);
			// 获取输出流对象
			OutputStream os = sc.getOutputStream();
			PrintWriter pw = new PrintWriter(os, true);
			String str = "你好吗";
			pw.println(str);

			//
			// try {
			// Thread.sleep(3000);
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// 接收服务端返回的结果
			InputStream is = sc.getInputStream();

			byte[] bs = new byte[1024];
			is.read(bs);
			String res = new String(bs);
//			String res = "";
//			int n = -1;
//			while ((n = is.read(bs)) != -1) {
//				String str1 = new String(bs);
//				res += str1;
//			}
			System.out.println("从服务器接收到的数据为:" + res);
			//
			// InputStreamReader ir = new InputStreamReader(is);
			// BufferedReader bf = new BufferedReader(ir);
			// String res = bf.readLine();
			// System.out.println("从服务器接收到的数据为:" + res);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
