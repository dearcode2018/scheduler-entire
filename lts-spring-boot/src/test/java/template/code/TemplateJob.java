/**
  * @filename TemplateJob.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package template.code;

import org.springframework.stereotype.Service;

import com.github.ltsopensource.core.domain.Action;
import com.github.ltsopensource.tasktracker.Result;
import com.github.ltsopensource.tasktracker.runner.JobContext;
import com.github.ltsopensource.tasktracker.runner.JobRunner;
import com.hua.job.CoreJob;

/**
 * @type TemplateJob
 * @description 任务名称|描述
 * @author qianye.zheng
 */
@Service
/*
  {"type":"TemplateJob"}
 */
public class TemplateJob extends CoreJob implements JobRunner
{

	//@Resource
	//private TemplateService templateService;
	
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
			// 业务逻辑，通常业务服务的方法
			
			logger.info("任务: {}, 执行完毕", description());
		} catch (Exception e)
		{
			logger.error("LTS触发任务: {}, 执行失败, 异常: {}", description(), e);
			
			  return new Result(Action.EXECUTE_FAILED, e.toString());
		}
		
		// 执行成功
		return new Result(Action.EXECUTE_SUCCESS,  "任务: " + description() + " 执行成功");
	}

	/**
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	protected String description()
	{
		return "任务名称|描述";
	}

	
}
