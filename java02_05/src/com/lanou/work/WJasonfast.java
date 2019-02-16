package com.lanou.work;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 *
 * @author LiuXu
 * @time2018年7月9日上午10:25:25
 **/
public class WJasonfast {

	public static void main(String[] args) {
		String str = "{'test1':'wx9fdb8ble7ce3c68f','test2': '123456789','testData1':{'testdatason1':'97895455','testdatason2':3,'testData2': [ {'testshuzu1':'12','testshuzu2':'11'},{'testshuzu1':'13','testshuzu2':'14'},{'testshuzu1':'15','testshuzu2':'16' } ] } }";

		JSONArray arr = JSONObject.parseObject(str).getJSONObject("testData1").getJSONArray("testData2");
		
		String s = arr.getJSONObject(0).getString("testshuzu1");
		System.out.println(s);

	}

}
