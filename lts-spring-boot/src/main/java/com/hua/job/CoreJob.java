/**
  * @filename CoreJob.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.job;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @type CoreJob
 * @description 
 * @author qianye.zheng
 */
public abstract class CoreJob
{
    // 记录业务日志。
	protected final Logger logger = LogManager.getLogger(getClass());
	
	/* 线程池任务执行器 */
	@Resource
	protected ThreadPoolTaskExecutor threadPoolTaskExecutor;
	
	/**
	 * 
	 * @description 任务描述
	 * @return
	 * @author qianye.zheng
	 */
	protected abstract String description();
	
	
}
