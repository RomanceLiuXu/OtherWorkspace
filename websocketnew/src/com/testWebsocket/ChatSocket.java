package com.testWebsocket;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.google.gson.Gson;

/**
 *	总通信管道
 * @author keb
 * @tim2018年9月13日下午2:20:13
 **/
@ServerEndpoint("/chatSocket")//这个注解用来标记一个类是 WebSocket 的处理器
public class ChatSocket {
	//定义一个全局变量sockets,用于存放每个登录用户的通信管道
	private static Set<ChatSocket> sockets = new HashSet<ChatSocket>();
	//定义一个session,用户存放登录用户的用户名
	private Session session;
	//定义一个全局变量map,key为用户名,该用户对应的session为value
	private static Map<String , Session> maps = new HashMap<String ,Session>();
	//定义一个数组,用于存放所有的登录用户,显示在聊天页面的用户列表栏中
	private static List<String> names = new ArrayList<>();
	private String username;
	//将java对象装换成JSON对象
	private Gson gson = new Gson();
	
	/**
	 * 监听用户登录的方法
	 * @throws UnsupportedEncodingException 
	 */
	@OnOpen
	public void open(Session session) throws UnsupportedEncodingException{
		this.session = session;
		//将登录用户的信息存放到通讯管道中去
		sockets.add(this);
		//获取URL后缀的用户名
		String queryString = session.getQueryString();
		//中文转码问题
		String name = URLDecoder.decode(queryString, "utf-8");
		//截取等号后面的参数信息(用户名),将参数信息赋值给全局的用户名
		String backname = name.substring(name.indexOf("=")+1);
		this.username=backname;
		//每登录一个用户,就将该用户放到names数组中去,用于刷新好友列表
		names.add(this.username);
		//将当前登录用户以及对应的session存入到map中
		this.maps.put(this.username, this.session);
		//将要发送给客户端的消息封装到对象中
		FromSerMsg message = new FromSerMsg();
		message.setAlert("用户"+this.username+"进入聊天室");
		//将当前所有登录用户存入到message中,用于广播发送到聊天页面
		message.setNames(names);
		//将聊天信息广播给所有通信管道(sockets);
		broadcast(sockets,gson.toJson(message));
	}
	
	/**
	 * 监听用户退出的方法
	 */
	@OnClose
	public void out(Session session){
				//移除退出登录的通信管道
				sockets.remove(this);
				//将用户名从names中踢出,用于刷新好哟列表
				names.remove(this.username);
				//更新消息信息
				FromSerMsg message = new FromSerMsg();
				message.setAlert(this.username+"退出聊天室!!!");
				//刷新好友列表
				message.setNames(names);
				broadcast(sockets,gson.toJson(message));
	}
	/**
	 * 接受客户端发送的消息,并将消息广播给所有的用户
	 * @param session
	 * @param msg
	 */
	@OnMessage
	public void receive(Session session ,String msg){
		System.out.println("客户端的消息:"+msg);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = sdf.format(new Date());
		//消息广播给所有
			FromSerMsg message = new FromSerMsg();
			message.setDate(time);
			message.setFromWho("<font color=red>"+this.username+":</font>");
			message.setSendMsg(msg);
			broadcast(sockets,gson.toJson(message));
	}
	/**
	 * 广播消息
	 * @param sockets
	 * @param msg
	 */
	private void broadcast(Set<ChatSocket> sockets, String msg) {
		//遍历当前所有的连接管道,将通知信息发送给每一个管道
		for (ChatSocket socket : sockets) {
			try {
				//通过session发送消息
				socket.session.getBasicRemote().sendText(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
