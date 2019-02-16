package com.lanou.myQuartz;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleTrigger;
import org.quartz.impl.StdSchedulerFactory;
import static org.quartz.DateBuilder.newDate;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;

import static org.quartz.TriggerBuilder.newTrigger;

/**
 *
 * @author LiuXu
 * @time2018年9月11日下午2:21:03
 **/
public class MyTest {

	public static void main(String[] args) throws SchedulerException {

		StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = stdSchedulerFactory.getDefaultScheduler();
		SimpleTrigger trigger = newTrigger().withIdentity("trigger1", "group1")//定义name/group
				.startNow()//一旦加入scheduler,立即生效
				.withSchedule(simpleSchedule()//使用SimpleTrigger
				.withIntervalInSeconds(1)//每隔一秒执行一次
				.repeatForever())//一直执行，奔腾到老不停歇
				.build();
		// 定义一个JobDetail
		JobDetail jobDetail = newJob(MyQuartZ.class)//定义Job类为MyQuartZ类，这是真正的执行逻辑所在
				.withIdentity("job1", "group1")//定义name/group
				.usingJobData("name", "quartz")//定义属性
				.build();
		// 加入这个调度
		scheduler.scheduleJob(jobDetail, trigger);
		// 启动
		scheduler.start();
	}

}
