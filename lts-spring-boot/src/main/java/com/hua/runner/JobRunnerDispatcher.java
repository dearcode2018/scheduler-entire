/**
  * @filename JobRunnerDispatcher.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.runner;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.github.ltsopensource.core.domain.Action;
import com.github.ltsopensource.core.domain.Job;
import com.github.ltsopensource.spring.boot.annotation.JobRunner4TaskTracker;
import com.github.ltsopensource.tasktracker.Result;
import com.github.ltsopensource.tasktracker.runner.JobContext;
import com.github.ltsopensource.tasktracker.runner.JobRunner;

/**
 * @type JobRunnerDispatcher
 * @description 
 * @author qianye.zheng
 */
@JobRunner4TaskTracker
public class JobRunnerDispatcher implements JobRunner, ApplicationContextAware
{

	/*  工作运行器 同步哈希Map，避免多线程相互干扰*/
	private static final ConcurrentHashMap<String, JobRunner> 
		JOB_RUNNER_MAP = new  ConcurrentHashMap<>();
	
	
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
		Result result = null;
		final Job job = jobContext.getJob();
		/*
		 * {"type":"JobRunnerA"}，在管理后台配置的json参数
		 * 统一转成大写
		 */
		final String type = job.getParam("type").toUpperCase();
		try
		{
			result = JOB_RUNNER_MAP.get(type).run(jobContext);
		} catch (Exception e)
		{
			// 异常报告
			System.out.println(e.toString());
			result = new Result(Action.EXECUTE_EXCEPTION, e.getMessage());
			e.printStackTrace();
		}
		
		return result;
	}
	
	/**
	 * @description 初始化将JobRunner类型的bean
	 * 放入同步Map中
	 * @param applicationContext
	 * @throws BeansException
	 * @author qianye.zheng
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException
	{
		final Map<String, JobRunner> map = applicationContext.getBeansOfType(JobRunner.class);
		for (String type : map.keySet())
		{
			// type: JobRunner 实例的名称，统一转成大写
			System.out.println("type = " + type);
			JOB_RUNNER_MAP.put(type.toUpperCase(), map.get(type));
		}
	}



}
