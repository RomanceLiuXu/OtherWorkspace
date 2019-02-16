package com.lanou;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 第一个客户端
 * 
 * @author LiuXu
 * @time2018年7月3日上午11:35:23
 **/
public class Client1 {

	public static void main(String[] args) {

		try {
			// 1.连接服务器端
//			可放回路地址127.0.0.1
			Socket sc = new Socket("127.0.0.1", 10000);
			// 2.准备发送的消息
			String str = "哈哈哈哈哈哈\n打打打打所多所多";
			// 3.通过sc获取一个输出流对象
			OutputStream os = sc.getOutputStream();
			// 使用输出流对象写入str
			// os.write(str.getBytes());
			// 4.实例化一个PrintWriter对象
			// OutputStream:输出流对象
			// autoFlush：是否自动刷新
			PrintWriter pw = new PrintWriter(os, true);
			// 5.向服务器端发送数据
			pw.println(str);

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
