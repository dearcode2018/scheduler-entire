/**
 * TriggerEntity.java
 * 
 * @author qye.zheng
 * 	version 1.0
 */
package com.hua.entity;

import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;

import com.hua.entity.BaseEntity;

/**
 * 描述: 
 * @author qye.zheng
 * TriggerEntity
 * 
 */
public final class TriggerEntity extends BaseEntity {
	
	/* 触发器 名称 */
	private String triggerName = "defaultTriggerName01";                 
	
	/* 工作组 名称 */
	private String groupName = "defaultGroupName01";
	
	/* 触发器Key对象 */
	private TriggerKey triggerKey;
	
	/* 详细对象 */
	private JobDetail jobDetail;
	
	/* 触发器 */
	private Trigger trigger;

	/**
	 * 
	 * 构造方法
	 * 描述: 
	 * 
	 * @author qye.zheng
	 * @param triggerName
	 * @param groupName
	 */
	public TriggerEntity(String triggerName, String groupName) {
		super();
		this.triggerName = triggerName;
		this.groupName = groupName;
	}

	/**
	 * 
	 * 构造方法
	 * 描述: 
	 * 
	 * @author qye.zheng
	 * @param triggerKey
	 */
	public TriggerEntity(TriggerKey triggerKey) {
		super();
		this.triggerKey = triggerKey;
	}

	
	/**
	 * @return the trigger
	 */
	public Trigger getTrigger() {
		if (null == triggerKey) {
			triggerKey = TriggerKey.triggerKey(triggerName, groupName);
		}
		// 构建一个触发器
		trigger = TriggerBuilder.newTrigger().withIdentity(triggerKey).build();
		
		return trigger;
	}
	
	/**
	 * @return the trigger
	 */
	public Trigger getTrigger(final JobDetail jobDetail) {
		this.jobDetail = jobDetail;
		// 构建一个触发器
		trigger = TriggerBuilder.newTrigger().forJob(jobDetail).build();
		
		return trigger;
	}

	/**
	 * @return the triggerName
	 */
	public String getTriggerName() {
		return triggerName;
	}

	/**
	 * @param triggerName the triggerName to set
	 */
	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
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
	 * @return the triggerKey
	 */
	public TriggerKey getTriggerKey() {
		return triggerKey;
	}

	/**
	 * @param triggerKey the triggerKey to set
	 */
	public void setTriggerKey(TriggerKey triggerKey) {
		this.triggerKey = triggerKey;
	}

	/**
	 * @return the jobDetail
	 */
	public JobDetail getJobDetail() {
		return jobDetail;
	}
	
}
