package com.lanou.work;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * @author LiuXu
 * @time2018年7月4日下午10:23:06
 **/
public class Work2 {

	public static void main(String[] args) {

		String jsonstr = "{'programmers':[{'firstName':'Brett','lastName':'McLaughlin','email':'aaaa'},{'firstName':'Jason','lastName':'Hunter','email':'bbbb'},{'firstName':'Elliotte','lastName':'Harold','email':'cccc'}],'authors':[{'firstName':'Isaac','lastName':'Asimov','genre':'science fiction'},{'firstName':'Tad','lastName':'Williams','genre':'fantasy'},{'firstName':'Frank','lastName':'Peretti','genre':'christian fiction'}],'musicians':[{'firstName':'Eric','lastName':'Clapton','instrument':'guitar'},{'firstName':'Sergei','lastName':'Rachmaninoff','instrument':'piano'}]}";

		// 创建集合
		List<Programmers> plist = new ArrayList<>();

		// 获取jp对象
		JsonParser jp = new JsonParser();
		// 获取json
		JsonObject obj = (JsonObject) jp.parse(jsonstr);

		JsonArray arr = (JsonArray) obj.get("programmers");

		for (int i = 0; i < arr.size(); i++) {
			JsonObject obj1 = new JsonObject();
			Programmers ps = new Programmers();
			ps.setFirstName(obj1.get("firstName").getAsString());
			ps.setLastName(obj1.get("lastName").getAsString());
			ps.setEmail(obj1.get("email").getAsString());
			plist.add(ps);
		}

		// 创建集合
		List<Authors> alist = new ArrayList<>();
		JsonArray arr1 = (JsonArray) obj.get("authors");

		for (int i = 0; i < arr1.size(); i++) {
			JsonObject obj1 = new JsonObject();
			Authors as = new Authors();
			as.setFirstName(obj1.get("firstName").getAsString());
			as.setLastName(obj1.get("lastName").getAsString());
			as.setGenre(obj1.get("genre").getAsString());
			alist.add(as);
		}

		// 创建集合
		List<Musicians> mlist = new ArrayList<>();
		JsonArray arr2 = (JsonArray) obj.get("musicians");
		for (int i = 0; i < arr2.size(); i++) {
			JsonObject obj1 = new JsonObject();
			Musicians ms = new Musicians();
			ms.setFirstName(obj1.get("firstName").getAsString());
			ms.setLastName(obj1.get("lastName").getAsString());
			ms.setInstrument(obj1.get("instrument").getAsString());
			mlist.add(ms);
		}

	}

}
