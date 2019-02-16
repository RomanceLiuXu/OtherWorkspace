package com.lanou.bean;

/**
 *
 * @author LiuXu
 * @time2018年8月22日上午9:52:27
 **/
public class Teacher {

	private String name;
    private String gender;
    
    
    public void show(){
    	System.out.println("name:"+name);
    	System.out.println("gender:"+gender);
    }
    
	public Teacher(String name, String gender) {
		super();
		this.name = name;
		this.gender = gender;
	}
    
    
    
    
    
}
