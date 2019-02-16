package com.match.dao.interf;

import java.util.List;

import com.match.beans.UserP;

/**
 * @author lichenfei
 * @time 2018年7月13日下午4:34:32
 *
 *       Dao层的接口
 *
 */
public interface HomeDaoI {

	/**
	 * 查询所用用户的信息和对应的图片信息
	 * 
	 * @param sex
	 *            性别
	 * @return 返回所有数据
	 */
	List<UserP> findAll(String sex);

	/**
	 * 分页查询符合用户的信息和图片信息
	 * 
	 * @param sex
	 * @param pnum
	 * @return
	 */
	List<UserP> pageFind(String sex,int pnum,int page);

	/**
	 * 查询符合性别要求所求的总页数
	 * 
	 * @param sex
	 * @param pnum
	 * @return
	 */
	int allPage(String sex, int pnum);

}
