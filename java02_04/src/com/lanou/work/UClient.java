package com.lanou.work;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * 用户客户端
 * 
 * @author LiuXu
 * @time2018年7月3日下午9:03:34
 **/
public class UClient {

	public static void main(String[] args) {

		try {
			// 实例化
			Socket sc = new Socket("127.0.0.1", 12345);
			// 准备用户名和密码
			Scanner scanner = new Scanner(System.in);
			System.out.println("请输入用户名:");
			String acount = scanner.next();
			System.out.println("请输入密码:");
			String psw = scanner.next();
			// 准备对象
			Users cU = new Users(acount, psw);
			// 获取输出流对象
			OutputStream os = sc.getOutputStream();
			ObjectOutputStream objOs = new ObjectOutputStream(os);
			objOs.writeObject(cU);
//			sc.shutdownInput();

			// 接收服务端返回的结果
			InputStream is = sc.getInputStream();
			int count = 0;
			while (count == 0) {
				count = is.available();
			}
			byte[] bs = new byte[count];
			is.read(bs);
			String res = new String(bs);
			System.out.println("服务器端返回的结果为:" + res);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
