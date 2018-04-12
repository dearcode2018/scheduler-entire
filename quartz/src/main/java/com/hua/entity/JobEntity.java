/**
 * JobEntity.java
 * 
 * @author qye.zheng
 * 	version 1.0
 */
package com.hua.entity;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.impl.calendar.AnnualCalendar;

import com.hua.entity.BaseEntity;

/**
 * 描述: Job实体，实现 org.quartz.Job 接口
 * @author qye.zheng
 * JobEntity
 * 
 */
public final class JobEntity extends BaseEntity implements Job {

	/**
	 * 描述: 具体要执行的业务逻辑
	 * @author qye.zheng
	 * 
	 * @param arg0
	 * @throws JobExecutionException
	 */
	@Override
	public void execute(final JobExecutionContext context) throws JobExecutionException {
		// 存储 Job 运行时的信息
		final JobDataMap dataMap = context.getMergedJobDataMap();
		AnnualCalendar ann = null;
		
		log.info("execute =====> execute something " );
		
	}

}
