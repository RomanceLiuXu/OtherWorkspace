package com.match.service.interf;



import java.util.List;

import com.match.beans.UserP;



/**
 * @author lichenfei
 * @time 2018年7月13日下午4:12:38
 *
 *       主页面接口
 *
 */
public interface HomeServiceI {
/**
 * 查询所用用户的信息和对应的图片信息
 * @param sex
 * 性别
 * @return
 * 返回所有数据
 */
	List<UserP> findAll(String sex);
}
