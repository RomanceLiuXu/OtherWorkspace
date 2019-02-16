package com.match.service;

import com.match.dao.FileUpDaoE;
import com.match.service.interf.FileUpServiceI;

/**
 *
 * @author LiuXu
 * @time2018年7月13日上午10:29:44
 **/
public class FileUpServiceE implements FileUpServiceI {
	// 实例化
	FileUpDaoE fileDao = new FileUpDaoE();

	@Override
	public boolean addPicture(int uid, String pname, String paddress) {
		boolean is = false;
		if (uid != 0 && pname != null && paddress != null) {
			// 调用dao层的方法
			is = fileDao.addPicture(uid, pname, paddress);
		}

		return is;
	}

}
