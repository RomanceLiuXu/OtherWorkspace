package com.lanou.myQuartz;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author LiuXu
 * @time2018年9月11日下午2:17:34
 **/
public class MyQuartZ implements Job {


	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException {
	
	   System.out.println("execute");
		
	}

}
