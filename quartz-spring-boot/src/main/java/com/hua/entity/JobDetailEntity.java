/**
 * JobDetailEntity.java
 * 
 * @author qye.zheng
 * 	version 1.0
 */
package com.hua.entity;

import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;

import com.hua.entity.BaseEntity;

/**
 * 描述: 
 * @author qye.zheng
 * JobDetailEntity
 * 
 */
public final class JobDetailEntity extends BaseEntity {

	/* 工作 名称 */
	private String jobName = "defaultJobName01";
	
	/* 工作组 名称 */
	private String groupName = "defaultGroupName01";
	
	/* 工作Key对象 */
	private JobKey jobKey;
	
	/* 工作接口 - 实现类 */
	private Class<? extends Job> jobClass;
	
	/* 工作细节 对象 */
	private JobDetail jobDetail;
	
	/**
	 * 
	 * 构造方法
	 * 描述: 
	 * 
	 * @author qye.zheng
	 * @param jobName
	 * @param groupName
	 * @param jobClass
	 */
	public JobDetailEntity(final String jobName, final String groupName, final Class<? extends Job> jobClass) {
		this.jobName = jobName;
		this.groupName = groupName;
		this.jobClass = jobClass;
	}
	
	/**
	 * 
	 * 构造方法
	 * 描述: 
	 * 
	 * @author qye.zheng
	 * @param jobKey
	 * @param jobClass
	 */
	public JobDetailEntity(final JobKey jobKey, final Class<? extends Job> jobClass) {
		this.jobKey = jobKey;
		this.jobClass = jobClass;
	}
	
	/**
	 * 
	 * 构造方法
	 * 描述: 
	 * 
	 * @author qye.zheng
	 * @param jobClass
	 */
	public JobDetailEntity(Class<? extends Job> jobClass) {
		super();
		this.jobClass = jobClass;
	}

	/**
	 * @return the jobDetail
	 */
	public JobDetail getJobDetail() {
		if (null == jobKey) {
			jobKey = JobKey.jobKey(jobName, groupName);
		}
		// 构建一个 工作细节 对象
		jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobKey).build();
		
		return jobDetail;
	}

	/**
	 * @return the jobName
	 */
	public String getJobName() {
		return jobName;
	}

	/**
	 * @param jobName the jobName to set
	 */
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the jobKey
	 */
	public JobKey getJobKey() {
		return jobKey;
	}

	/**
	 * @param jobKey the jobKey to set
	 */
	public void setJobKey(JobKey jobKey) {
		this.jobKey = jobKey;
	}
	
}
