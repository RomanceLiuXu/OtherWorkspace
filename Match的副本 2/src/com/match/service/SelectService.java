package com.match.service;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.match.beans.Picture;
import com.match.beans.User;
import com.match.beans.UserP;
import com.match.dao.SelectDao;
import com.match.service.interf.SelectServiceI;



/**
 *
 * @author xxc
 * @time 2018年7月11日下午8:15:28
 **/
public class SelectService implements SelectServiceI {
	// 实例化dao层
	SelectDao dao = new SelectDao();

	/**
	 * 查询与用户匹配的同城信息
	 * 
	 * @param uid
	 *            用户id
	 * @param age
	 *            用户年龄
	 * @param sex
	 *            用户性别
	 * @param adress
	 *            用户住址
	 * @return 返回与客户匹配的所有成员的信息及图片信息
	 */
	@Override
	public List<UserP> selectMethod(int uid, int age, String sex, String address) {
		List<UserP> list = new ArrayList<>();

		if (uid != 0 && age > 18) {
			// 转到dao层
			list = dao.selectMethod(uid, age, sex, address);
		}
		return list;
	}

	/**
	 * 从数据库查询某个人的用户信息
	 * 
	 * @param 用户的id
	 */
	@Override
	public Map<User, Picture> perMethod(int id) {
		Map<User, Picture> map2 = new HashMap<>();
		if (id > 0) {
			// 调取dao层
			map2 = dao.perMethod(id);
		}

		return map2;
	}

}
