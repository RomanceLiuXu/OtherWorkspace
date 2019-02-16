package com.lanou.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lanou.bean.Item;

/**
*
* @author LiuXu
* @time2018年9月28日下午2:15:42
**/
@Controller
public class EchartController {

	@RequestMapping("showChart.do")
	public String show(){
		return "showChart";
	}
	
	@RequestMapping("show.do")
	@ResponseBody
	public List<Item> showChart(){
		List<Item> items = new ArrayList<>();
		Item t1 = new Item("香蕉", 100);
		Item t2 = new Item("苹果", 200);
		Item t3 = new Item("葡萄", 150);
		Item t4 = new Item("梨子", 90);
		Item t5 = new Item("西瓜", 30);
		items.add(t1);
		items.add(t2);
		items.add(t3);
		items.add(t4);
		items.add(t5);
		return items;
	}
	
	
}
