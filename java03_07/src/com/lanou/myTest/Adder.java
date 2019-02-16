package com.lanou.myTest;
/**
*  加法类：请求接收者
* @author mzy
* @time 2018年8月15日下午8:10:51
**/
public class Adder {
      private int num=0;//定义初始值为0
     /**
      * 加法操作，每次将传入的值与num做加法运算，再将结果返回
      * @param value传入的数据
      * @return 运算完后的值
      */
     public int add(int value) {
		num+=value ;
		return num;
	} 
      
}
