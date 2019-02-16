package com.lanou;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * UDP-传对象
 * 
 * @author LiuXu
 * @time2018年7月4日上午10:56:49
 **/
public class Client2 {

	public static void main(String[] args) {

		try {
			// 实例化
			DatagramSocket socket = new DatagramSocket(6666);
			// 向服务器发送对象
			// 准备传输的对象
			// 实例化
			Car car = new Car("小白", "大众");
			// 实例化ByteArrayOutputStream对象
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			// 实例化ObjectOutputStream对象
			ObjectOutputStream obj = new ObjectOutputStream(bos);
			// 调用方法写入对象
			obj.writeObject(car);
			// 实例化DatagramPacket对象
			DatagramPacket dp = new DatagramPacket(bos.toByteArray(), bos.toByteArray().length,
					InetAddress.getByName("127.0.0.1"), 5555);
			// 发送数据
			socket.send(dp);

			// 接收服务器回复的数据
			// 创建容器
			byte[] bytes = new byte[1024];
			// 实例化
			DatagramPacket dp1 = new DatagramPacket(bytes, bytes.length);
			socket.receive(dp1);
			// 实例化
			ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
			// 实例化
			ObjectInputStream objIs = new ObjectInputStream(bis);
			Car car2 = (Car) objIs.readObject();
			System.out.println(car2);

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
