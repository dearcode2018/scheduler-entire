/**
  * @filename JobRunnerA.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.job;

import org.springframework.stereotype.Service;

import com.github.ltsopensource.core.domain.Action;
import com.github.ltsopensource.tasktracker.Result;
import com.github.ltsopensource.tasktracker.runner.JobContext;
import com.github.ltsopensource.tasktracker.runner.JobRunner;

/**
 * @type JobRunnerA
 * @description 
 * @author qianye.zheng
 */
@Service
/*
  {"type":"JobRunnerA"}
 */
public class JobRunnerA extends CoreJob implements JobRunner
{

	/**
	 * @description 
	 * @param jobContext
	 * @return
	 * @throws Throwable
	 * @author qianye.zheng
	 */
	@Override
	public Result run(JobContext jobContext) throws Throwable
	{
		try
		{
			logger.info("LTS触发任务: " + description() + ", "+ jobContext);
			// TODO 业务逻辑，通常业务服务的方法
			
			logger.info("任务: " + description() +  ", 执行完毕");
		} catch (Exception e)
		{
			logger.error("LTS触发任务: {}, 执行失败, 异常: {}", description(), e);
			
			  return new Result(Action.EXECUTE_FAILED, e.getCause().toString());
		}
		
		// 执行成功
		return new Result(Action.EXECUTE_SUCCESS,  "任务: " + description() + ", 执行成功");
	}

	/**
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	protected String description()
	{
		return "JobRunnerA";
	}

}
