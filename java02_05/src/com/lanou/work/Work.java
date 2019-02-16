package com.lanou.work;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.alibaba.fastjson.JSONPObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.lanou.Car;

/**
 *
 * @author LiuXu
 * @time2018年7月4日下午7:35:02
 **/
public class Work {

	public static void main(String[] args) {

		// { 'test1': 'wx9fdb8ble7ce3c68f', 'test2': '123456789', 'testData1': {
		// 'testdatason1': '97895455''testdatason2':3, 'testData2': [ {
		// 'testshuzu1':'12' 'testshuzu1':'11' }, { 'testshuzu2':'13'
		// 'testshuzu2':'14' }, , { 'testshuzu3':'15' 'testshuzu3':'16' } ] } }
		// json数据
		String str = "{'test1':'wx9fdb8ble7ce3c68f','test2': '123456789','testData1':{'testdatason1':'97895455','testdatason2':3,'testData2': [ {'testshuzu1':'12','testshuzu2':'11'},{'testshuzu1':'13','testshuzu2':'14'},{'testshuzu1':'15','testshuzu2':'16' } ] } }";


		// 新建list存放对象
		List<Testdata2> list1 = new ArrayList<>();
		// 实例化
		JsonParser jp = new JsonParser();
		// 通过jp对象获取JsonObject对象
		JsonObject obj = (JsonObject) jp.parse(str);
		// 实例化
		AllTest<Testdata1<List<Testdata2>>> aTest = new AllTest<>();
		aTest.setTest1(obj.get("test1").getAsString());
		aTest.setTest2(obj.get("test2").getAsString());
		
		System.out.println(aTest.getTest1() + ":" + aTest.getTest2());

		// 实例化
		Testdata1<List<Testdata2>> td1 = new Testdata1<>();
		JsonObject obj2 = (JsonObject) obj.get("testData1");
		td1.setTestdatason1(obj2.get("testdatason1").getAsString());
		td1.setTestdatason2(obj2.get("testdatason2").getAsInt());
		
		System.out.println(td1.getTestdatason1() + ":" + td1.getTestdatason2());

		// 通过obj获取集合类的对象
		JsonArray arr = (JsonArray) obj2.get("testData2");
		// 遍历
		for (int i = 0; i < arr.size(); i++) {
			Testdata2 mtd = new Testdata2();
			JsonObject obj1 = (JsonObject) arr.get(i);
			mtd.setTestshuzu1(obj1.get("testshuzu1").getAsString());
			mtd.setTestshuzu2(obj1.get("testshuzu2").getAsString());
			list1.add(mtd);
		}

		td1.setTestdata2(list1);

		aTest.setTestdata1(td1);

		System.out.println(aTest);

		
		
		
		
	}

}
