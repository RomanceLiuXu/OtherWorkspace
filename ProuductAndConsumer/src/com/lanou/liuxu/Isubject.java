package com.lanou.liuxu;

/**
 * 接口
 * @author LiuXu
 * @time2018年8月7日上午11:07:39
 **/
public interface Isubject {
/**
 * 代理对象类和真实对象类都要实现这个接口
 * 原因：
 * 既然代理对象要为真实对象服务，当然要和真实对象有着一样方法，即有着相同的行为
 */

	void byMac();
	
}
