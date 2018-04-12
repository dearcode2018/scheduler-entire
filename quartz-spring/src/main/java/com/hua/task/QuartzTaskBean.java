/**
  * @filename QuartzJobBean.java
  * @description 
  * @version 1.0
  * @author qye.zheng
 */
package com.hua.task;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

 /**
 * @type QuartzJobBean
 * @description 
 * @author qye.zheng
 */
public final class QuartzTaskBean extends QuartzJobBean {

	/**
	 * @description 任务
	 * @param context
	 * @throws JobExecutionException
	 * @author qye.zheng
	 */
	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		String value = context.getMergedJobDataMap().getString("taskKey");
		System.out.println("QuartzTaskBean.executeInternal() value = " + value);
	}

}
