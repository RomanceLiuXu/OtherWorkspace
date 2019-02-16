package com.match.service;



import java.util.List;

import com.match.beans.UserP;
import com.match.dao.HomeDaoE01;
import com.match.dao.interf.HomeDaoI01;





/**
 * @author lichenfei
 * @time 2018年7月14日下午8:42:31
 *
 *
 *
 */
public class HomeServiceE01 implements HomeDaoI01 {

//	实例化dao层：
	HomeDaoE01 dao = new HomeDaoE01();
	@Override
	public List<UserP> show(int uid) {
		// 判断前端传来的数据：
       List<UserP> list = dao.show(uid);
       
		return list;
	}

}
