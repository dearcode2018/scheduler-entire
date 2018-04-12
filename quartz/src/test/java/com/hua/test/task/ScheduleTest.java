/**
 * 描述: 
 * ScheduleTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.task;

import org.junit.Test;

import com.hua.entity.SchedulerEntity;
import com.hua.test.BaseTest;

/**
 * 描述: 
 * 
 * @author qye.zheng
 * ScheduleTest
 */
public final class ScheduleTest extends BaseTest {
	
	
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void testSimple() {
		try {
			
			SchedulerEntity schedule = new SchedulerEntity();
			schedule.startSchedule();
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@Test
	public void test() {
		try {
			
			
		} catch (Exception e) {
			log.error("test =====> ", e);
		}
	}
	
	
}
