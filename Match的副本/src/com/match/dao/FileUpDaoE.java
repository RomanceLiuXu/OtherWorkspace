package com.match.dao;

import com.match.dao.interf.FileUPDaoI;
import com.match.service.interf.FileUpServiceI;
import com.match.util.SQLUtil2;

/**
 * 连接数据库，添加用户上传的图片信息
 * 
 * @author LiuXu
 * @time2018年7月13日上午10:42:20
 **/
public class FileUpDaoE implements FileUPDaoI {

	@Override
	public boolean addPicture(int uid, String pname, String paddress) {
		// 标示，是否添加成功
		boolean isAdd = false;
		if (uid != 0 && pname != null && paddress != null) {
			// 准备sql语句
			String pn = "'" + pname + "'";
			String pa = "'" + paddress + "'";
			String sql = "insert into picture(pname,paddress,uid) values" + "(" + pname + "," + paddress + "," + uid
					+ ")";
			System.out.println("sql语句:" + sql);
			// 接收返回的结果
			isAdd = SQLUtil2.add(sql);
			System.out.println(isAdd);

		}

		return false;
	}

}
