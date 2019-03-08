/**
  * @filename MyJobRunner.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.runner;

import com.github.ltsopensource.core.domain.Action;
import com.github.ltsopensource.tasktracker.Result;
import com.github.ltsopensource.tasktracker.runner.JobContext;
import com.github.ltsopensource.tasktracker.runner.JobRunner;

 /**
 * @type MyJobRunner
 * @description 
 * @author qianye.zheng
 */
public class MyJobRunner implements JobRunner
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
		System.out.println("执行任务: MyJobRunner.run()");
		
		return new Result(Action.EXECUTE_SUCCESS, "执行成功了，哈哈");
	}

}
