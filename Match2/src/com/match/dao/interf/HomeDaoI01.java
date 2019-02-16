package com.match.dao.interf;



import java.util.List;

import com.match.beans.UserP;



/**
*@author lichenfei 
 @time 2018年7月14日下午8:38:00
*
*
*
*/
public interface HomeDaoI01 {
/**
 * 
 * @param uid
 * W唯一的标识:
 * @return
 */
	List<UserP> show(int uid);
	
}
