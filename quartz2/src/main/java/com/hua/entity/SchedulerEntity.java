/**
 * SchedulerEntity.java
 * 
 * @author qye.zheng
 * 	version 1.0
 */
package com.hua.entity;

import java.util.Date;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerContext;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import com.hua.entity.BaseEntity;
import com.hua.entity.JobEntity;

/**
 * 描述: 
 * @author qye.zheng
 * SchedulerEntity
 * 
 */
public final class SchedulerEntity extends BaseEntity {
	
	private Scheduler scheduler;

	private JobDetail jobDetail;
	
	private Trigger trigger;
	
	public void startSchedule() {
		try {
			Date runTime = new Date();
			String jobName = "job1";
			String triggerName = "trigger1";
			String groupName = "group1";
			scheduler = StdSchedulerFactory.getDefaultScheduler();
			
			jobDetail = JobBuilder.newJob(JobEntity.class).withIdentity(jobName, groupName).build();
			// 创建 SimpleTrigger实例
			trigger = TriggerBuilder.newTrigger().withIdentity(triggerName, groupName).startAt(runTime).build();
			TriggerBuilder.newTrigger().withIdentity(triggerName, groupName);
			
			// 注册并调度
			scheduler.scheduleJob(jobDetail, trigger);
			
			
			// Scheduler 调度 上下文
			SchedulerContext context = null;
			
			
			
			// 启动调度器
			scheduler.start();
			
			Thread.sleep(5 * 1000);
			
			// 调度器终止运行
			scheduler.shutdown(true);
			
			log.info("startSchedule =====> 结束运行");
			
		} catch (Exception e) {
			log.error("startSchedule =====> ", e);
		}
	}
	
}
