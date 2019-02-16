package com.match.service;



import java.util.ArrayList;
import java.util.List;

import com.match.beans.UserP;
import com.match.dao.HomeDaoE;
import com.match.service.interf.HomeServiceI;



/**
 * @author lichenfei
 * @time 2018年7月13日下午4:14:01
 *
 *
 *
 */
public class HomeServiceE implements HomeServiceI {

	// dao层对象
    HomeDaoE dao = new HomeDaoE();
	/**
	 * 
	 */
	@Override
	public List<UserP> findAll(String sex) {
		// 实例化一个list对象
		List<UserP> lists = new ArrayList<UserP>();
		// 判断字符串是否为空：
		// 对controller传来的sex数据进行判断：
		if (!sex.equals("") && sex != null) {
			// 使用dao层对象调用查询方法：
           lists = dao.findAll(sex);
		}       
         System.out.println(lists.toString());
		return lists;                                           
	}

}
