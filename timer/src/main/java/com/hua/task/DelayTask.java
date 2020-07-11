/**
  * @filename DelayTask.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.task;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @type DelayTask
 * @description 延迟任务
 * @author qianye.zheng
 */
public class DelayTask implements Delayed {

	/**
	 * @description 
	 * @param o
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public int compareTo(Delayed o) {
		return 0;
	}

	/**
	 * @description 
	 * @param unit
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public long getDelay(TimeUnit unit) {
		
		return unit.convert(3, TimeUnit.SECONDS);
	}

}
