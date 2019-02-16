package com.match.service.interf;
/**
*
* @author LiuXu
* @time2018年7月13日上午10:26:34
**/
public interface FileUpServiceI {

    /**
     *  注册时添加用户图片的方法
     * @param uid 用户id
     * @param pname  图片名称
     * @param paddress 图片的路径
     * @return 是否添加成功
     */
	boolean addPicture(int uid,String pname,String paddress);
	
	
}
