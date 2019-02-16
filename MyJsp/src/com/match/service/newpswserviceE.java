package com.match.service;

import com.match.beans.User;
import com.match.dao.newpswDaoE;
import com.match.service.interf.newpswServiceI;

/**
 *
 * @author keb
 * @tim2018年7月14日上午8:58:56
 **/
public class newpswserviceE implements newpswServiceI{

	@Override
	public boolean newpswMethod(User user) {
		newpswDaoE newpswDao = new newpswDaoE();
		boolean boo = newpswDao.newpswMethod(user);
		return boo;
	}

	

}
