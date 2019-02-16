package com.match.dao.interf;

/**
 *
 * @author LiuXu
 * @time2018年7月13日上午10:35:42
 **/
public interface FileUPDaoI {

	/**
	 * 连接数据库查询，将图片信息添加到数据库中
	 * 
	 * @param uid 用户id 
	 * @param pname 图片名称
	 * @param paddress 图片地址
	 * @return 是否添加成功
	 */
	boolean addPicture(int uid, String pname, String paddress);
    
}
