package com.lanou;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 服务端---接收数据判断
 * 
 * @author LiuXu
 * @time2018年7月4日下午2:00:46
 **/
public class Service4 {

	public static void main(String[] args) {

		try {
			DatagramSocket socket = new DatagramSocket(5555);
			byte[] buyes = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buyes, buyes.length);
			socket.receive(dp);
			// String str = new String(buyes);
			System.out.println(dp.getLength());
			String str = new String(buyes, 0, dp.getLength());
			if (str.equals("lhl")) {
				System.out.println("正确");
			} else {
				System.out.println("错误");
			}

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
