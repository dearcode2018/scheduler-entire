/**
 * 描述: 
 * TimerTest.java
 * 
 * @author qye.zheng
 *  version 1.0
 */
package com.hua.test.task;

//静态导入
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.assumeFalse;
import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.hua.test.BaseTest;


/**
 * 描述: 
 * 
 * @author qye.zheng
 * TimerTest
 */
//@DisplayName("测试类名称")
//@Tag("测试类标签")
//@Tags({@Tag("测试类标签1"), @Tag("测试类标签2")})
public final class TimerTest extends BaseTest {

	
	
	
	/**
	 * 指定时间(第/一次)、当前时间、基于当前时间延迟、周期
	 * 
	 * 
	 * 1) 指定执行时间
	 * 2) 从当前时间开始，延迟指定毫秒数执行
	 * 3) 从当前时间开始，指定毫秒数 + 指定周期执行
	 * 4) 指定第一次执行时间，指定周期
	 * 5) 指定第一次执行时间，固定频率
	 * 6) 指定第一次执行时间，固定频率
	 * 
	 * 
		schedule(TimerTask task, Date time)
		schedule(TimerTask task, Date firstTime, long period)
		schedule(TimerTask task, long delay)
		schedule(TimerTask task, long delay, long period)
		scheduleAtFixedRate(TimerTask task, Date firstTime, long period) 
		scheduleAtFixedRate(TimerTask task, long delay, long period)
	 * 
	 */
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testTimer() {
		try {
			Timer timer = new Timer();
			long periodMillisec = 3 * 1000L;
			//LocalDateTime localDateTime = LocalDateTime.now();
			Calendar calendar = Calendar.getInstance();
			// 控制小时
			calendar.set(Calendar.HOUR_OF_DAY, 10);
			// 控制分钟
			calendar.set(Calendar.MINUTE, 20);
			// 控制秒
			calendar.set(Calendar.SECOND, 0);
			// 执行任务时间为12:00:00
			Date dateTime = calendar.getTime();
			timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					System.out.println("TimerTest.testTimer().new TimerTask() {...}.run()");
				}
			}, dateTime, periodMillisec);
			
			// 避免主线程停止后，定时器不起作用
			TimeUnit.SECONDS.sleep(60);
			
		} catch (Exception e) {
			log.error("testTimer =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testDate() {
		try {
			/*
			 * 指定日期时间，只执行一次
			 * 只要当前时间大于等于指定的时间就会触发一次
			 */
			Timer timer = new Timer();
			//LocalDateTime localDateTime = LocalDateTime.now();
			Calendar calendar = Calendar.getInstance();
			// 控制小时
			calendar.set(Calendar.HOUR_OF_DAY, 10);
			// 控制分钟
			calendar.set(Calendar.MINUTE, 20);
			// 控制秒
			calendar.set(Calendar.SECOND, 0);
			// 执行任务时间为12:00:00
			Date dateTime = calendar.getTime();
			timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					System.out.println("TimerTest.testTimer().new TimerTask() {...}.run()");
				}
			}, dateTime);
			
			// 避免主线程停止后，定时器不起作用
			TimeUnit.SECONDS.sleep(30);
			
		} catch (Exception e) {
			log.error("testDate =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testDatePeriod() {
		try {
			/*
			 * 指定日期时间，只执行一次
			 * 只要当前时间大于等于指定的时间就会触发一次
			 */
			// 执行周期，第一次执行之后，后续的执行时间间隔
			long periodMillisec = 3 * 1000L;
			Timer timer = new Timer();
			//LocalDateTime localDateTime = LocalDateTime.now();
			Calendar calendar = Calendar.getInstance();
			// 控制小时
			calendar.set(Calendar.HOUR_OF_DAY, 10);
			// 控制分钟
			calendar.set(Calendar.MINUTE, 20);
			// 控制秒
			calendar.set(Calendar.SECOND, 0);
			// 执行任务时间为12:00:00
			Date firstTime = calendar.getTime();
			timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					System.out.println("TimerTest.testTimer().new TimerTask() {...}.run()");
				}
			}, firstTime, periodMillisec);
			
			// 避免主线程停止后，定时器不起作用
			TimeUnit.SECONDS.sleep(30);
			
		} catch (Exception e) {
			log.error("testDatePeriod =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testDelay() {
		try {
			/*
			 * 从当前时间开始，延迟指定的毫秒数执行，只执行一次
			 */
			// 执行周期，第一次执行之后，后续的执行时间间隔
			long delay = 3 * 1000L;
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					System.out.println("TimerTest.testTimer().new TimerTask() {...}.run()");
				}
			}, delay);
			
			// 避免主线程停止后，定时器不起作用
			TimeUnit.SECONDS.sleep(30);
			
		} catch (Exception e) {
			log.error("testDelay =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testDelayPeriod() {
		try {
			/*
			 * 从当前时间开始，延迟指定的毫秒数执行，按指定周期执行
			 * 只要当前时间大于等于指定的时间就会触发一次
			 */
			// 执行周期，第一次执行之后，后续的执行时间间隔
			long delay = 2 * 1000L;
			long periodMillisec = 5 * 1000L;
			Timer timer = new Timer();
			//LocalDateTime localDateTime = LocalDateTime.now();
			Calendar calendar = Calendar.getInstance();
			// 控制小时
			calendar.set(Calendar.HOUR_OF_DAY, 10);
			// 控制分钟
			calendar.set(Calendar.MINUTE, 20);
			// 控制秒
			calendar.set(Calendar.SECOND, 0);
			// 执行任务时间为12:00:00
			Date firstTime = calendar.getTime();
			timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					System.out.println("TimerTest.testTimer().new TimerTask() {...}.run()");
				}
			}, delay, periodMillisec);
			
			// 避免主线程停止后，定时器不起作用
			TimeUnit.SECONDS.sleep(30);
			
		} catch (Exception e) {
			log.error("testDelayPeriod =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testAtFixedRate1() {
		try {
			/*
			 * 从当前时间开始，延迟指定的毫秒数执行，按固定的周期执行，
			 * 不受上一次执行时长的影响
			 * 只要当前时间大于等于指定的时间就会触发一次
			 */
			// 执行周期，第一次执行之后，后续的执行时间间隔
			long periodMillisec = 5 * 1000L;
			Timer timer = new Timer();
			//LocalDateTime localDateTime = LocalDateTime.now();
			Calendar calendar = Calendar.getInstance();
			// 控制小时
			calendar.set(Calendar.HOUR_OF_DAY, 10);
			// 控制分钟
			calendar.set(Calendar.MINUTE, 20);
			// 控制秒
			calendar.set(Calendar.SECOND, 0);
			// 执行任务时间为12:00:00
			Date firstTime = calendar.getTime();
			timer.scheduleAtFixedRate(new TimerTask() {
				
				@Override
				public void run() {
					System.out.println("TimerTest.testTimer().new TimerTask() {...}.run()");
				}
			}, firstTime, periodMillisec);
			
			// 避免主线程停止后，定时器不起作用
			TimeUnit.SECONDS.sleep(30);
			
		} catch (Exception e) {
			log.error("testAtFixedRate1 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void testAtFixedRate2() {
		try {
			/*
			 * 从当前时间开始，延迟指定的毫秒数执行，按固定的周期执行，
			 * 不受上一次执行时长的影响
			 * 只要当前时间大于等于指定的时间就会触发一次
			 */
			// 执行周期，第一次执行之后，后续的执行时间间隔
			long delay = 2 * 1000L;
			long periodMillisec = 5 * 1000L;
			Timer timer = new Timer();
			timer.scheduleAtFixedRate(new TimerTask() {
				
				@Override
				public void run() {
					System.out.println("TimerTest.testTimer().new TimerTask() {...}.run()");
				}
			}, delay, periodMillisec);
			
			// 避免主线程停止后，定时器不起作用
			TimeUnit.SECONDS.sleep(30);
			
		} catch (Exception e) {
			log.error("testAtFixedRate2 =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	//@DisplayName("test")
	@Test
	public void test() {
		try {
			
			
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
	@DisplayName("testTemp")
	@Test
	public void testTemp() {
		try {
			
			
		} catch (Exception e) {
			log.error("testTemp=====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("testCommon")
	@Test
	public void testCommon() {
		try {
			
			
		} catch (Exception e) {
			log.error("testCommon =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("testSimple")
	@Test
	public void testSimple() {
		try {
			
			
		} catch (Exception e) {
			log.error("testSimple =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("testBase")
	@Test
	public void testBase() {
		try {
			
			
		} catch (Exception e) {
			log.error("testBase =====> ", e);
		}
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]开始之前运行
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("beforeMethod")
	@Tag(" [每个测试-方法]结束之后运行")
	@BeforeEach
	public void beforeMethod() {
		System.out.println("beforeMethod()");
	}
	
	/**
	 * 
	 * 描述: [每个测试-方法]结束之后运行
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("afterMethod")
	@Tag(" [每个测试-方法]结束之后运行")
	@AfterEach
	public void afterMethod() {
		System.out.println("afterMethod()");
	}
	
	/**
	 * 
	 * 描述: 测试忽略的方法
	 * @author qye.zheng
	 * 
	 */
	@Disabled
	@DisplayName("ignoreMethod")
	@Test
	public void ignoreMethod() {
		System.out.println("ignoreMethod()");
	}
	
	/**
	 * 
	 * 描述: 解决ide静态导入消除问题 
	 * @author qye.zheng
	 * 
	 */
	@DisplayName("noUse")
	@Disabled("解决ide静态导入消除问题 ")
	private void noUse() {
		String expected = null;
		String actual = null;
		Object[] expecteds = null;
		Object[] actuals = null;
		String message = null;
		
		assertEquals(expected, actual);
		assertEquals(message, expected, actual);
		assertNotEquals(expected, actual);
		assertNotEquals(message, expected, actual);
		
		assertArrayEquals(expecteds, actuals);
		assertArrayEquals(expecteds, actuals, message);
		
		assertFalse(true);
		assertTrue(true);
		assertFalse(true, message);
		assertTrue(true, message);
		
		assertSame(expecteds, actuals);
		assertNotSame(expecteds, actuals);
		assertSame(expecteds, actuals, message);
		assertNotSame(expecteds, actuals, message);
		
		assertNull(actuals);
		assertNotNull(actuals);
		assertNull(actuals, message);
		assertNotNull(actuals, message);
		
		fail();
		fail("Not yet implemented");
		
		dynamicTest(null, null);
		
		assumeFalse(false);
		assumeTrue(true);
		assumingThat(true, null);
	}

}
