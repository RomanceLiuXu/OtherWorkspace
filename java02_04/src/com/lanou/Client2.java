package com.lanou;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 第二个客户端
 * 
 * @author LiuXu
 * @time2018年7月3日下午2:08:11
 **/
public class Client2 {
	public static void main(String[] args) {
		try {
			// 连接服务器
			Socket sc = new Socket("127.0.0.1", 12222);
			// // 获取输出流对象
			OutputStream os = sc.getOutputStream();
			// String str = "哈哈哈";
			// // 准备传输的数据
			// os.write(str.getBytes());

			// 实例化OutputStreamWriter对象
			// 参数:OutputStream 输出流对象
			OutputStreamWriter ow = new OutputStreamWriter(os);
			// 实例化BufferedWriter
			// Write为抽象类 OutputStreamWriter为实现类
			BufferedWriter bw = new BufferedWriter(ow);
			bw.write("哈哈哈卡啦啦啦啦啦啦啦啦我");
			bw.flush();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
