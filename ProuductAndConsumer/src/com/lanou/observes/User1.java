package com.lanou.observes;
/**
*
* @author LiuXu
* @time2018年8月7日下午2:26:37
**/
public class User1  implements Observer{

	@Override
	public void update(String str) {
     System.out.println(str);
		
	}

	

}
