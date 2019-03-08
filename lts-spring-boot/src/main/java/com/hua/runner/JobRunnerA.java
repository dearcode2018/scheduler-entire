/**
  * @filename JobRunnerA.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.runner;

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
public class JobRunnerA implements JobRunner
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
			System.out.println("LTS触发任务: " + jobContext);
			// TODO 业务逻辑，通常业务服务的方法
			System.out.println("JobRunnerA.run() 业务逻辑，通常业务服务的方法");
			
			
			System.out.println("JobRunnerA 执行完毕");
		} catch (Exception e)
		{
			System.out.println("LTS触发任务执行失败: " + jobContext + ", exception: " + e.getMessage());
			
			  return new Result(Action.EXECUTE_FAILED, e.getMessage());
		}
		
		return new Result(Action.EXECUTE_SUCCESS, "JobRunnerA执行成功..");
	}

}
