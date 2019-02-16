package com.liuxu.myTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import au.com.bytecode.opencsv.CSVReader;

/**
 *
 * @author LiuXu
 * @time2018年9月25日下午2:01:22
 **/
public class Test2 {

	public static void main(String[] args) throws IOException {
		CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream("/Users/xalo/Desktop/one.csv"), "UTF-8"));
		String[] strs = null;
		Map<String, Integer> maps = new HashMap<>();
		while ((strs=reader.readNext())!=null) {
			for (String string : strs) {
				if (!maps.containsKey(string)) {
					maps.put(string, 1);
				}else{
					Integer con = maps.get(string);
					con++;
					maps.put(string, con);
				}
			}
		}
		FileWriter fileWriter = new FileWriter("/Users/xalo/Desktop/count.txt");
		 Set<Entry<String, Integer>> entrySet = maps.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			fileWriter.write(entry.getKey()+"/"+entry.getValue()+"\n");
		}
		fileWriter.close();
		reader.close();
	}
	
}
