package com.lanou.service;

import java.util.ArrayList;
import java.util.List;

import com.lanou.bean.User;
import com.lanou.dao.DatabaseDaoE;
import com.lanou.dao.interf.DataBaseDaoI;
import com.lanou.service.interf.DataBaseServiceI;


/**
 *
 * @author LiuXu
 * @time2018年7月19日下午8:29:44
 **/
public  class DataBaseServiceE implements DataBaseServiceI {
	// 实例化dao层
	DataBaseDaoI dao = new DatabaseDaoE();

	@Override
	public boolean addUser(String name, String sex, String psw) {
		boolean isAdd = false;
		// 判断非空和非null
		String[] data = { name, sex, psw };
		if (judgeEmpty(data)) {
			// 有效数据
			// 调用方法
			isAdd = dao.addUser(name, sex, psw);

		}

		return isAdd;
	}

	@Override
	public boolean updateUser(int uid, String name, String sex, String psw) {
		String[] data = { name, sex, psw };
		boolean isUpdata = false;
		// 判断非空和非null
		if (judgeEmpty(data) && uid > 0) {
			// 调方法
			isUpdata = dao.updateUser(uid, name, sex, psw);
		}

		return isUpdata;
	}

	public boolean deleteUser(int uid) {
		boolean idDelete = false;
		if ( uid > 0) {
			idDelete = dao.deleteUser(uid);
		}

		return idDelete;
	}

	@Override
	public List<User> selectUser() {

		List<User> users = dao.selectUser();

		return users;
	}

	// 判断非空的方法
	public boolean judgeEmpty(String[] data) {
		boolean is = true;
		for (int i = 0; i < data.length; i++) {
			if (data[i] == null || data.equals("")) {
				is = false;
				break;
			}
		}
		return is;
	}

	@Override
	public List<User> pageFind(int pnum, int page) {
		// 实例化
		List<User> lists = new ArrayList<>();
		// 判断
		if (pnum > 0 && page > 0) {
			// 调用查询方法
			lists = dao.pageFind(pnum, page);
		}

		return lists;

	}

}
