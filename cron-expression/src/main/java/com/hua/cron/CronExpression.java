/**
  * @filename CronExpression.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.cron;

 /**
 * @type CronExpression
 * @description cron表达式
 * @author qianye.zheng
 */
public class CronExpression
{

	/**
	 * cron表达式是一个字符串，以5或6个空格隔开，分为6或7个域，分为6或7个域，
	 * 每个域代表一个含义.
	 * 
	 * 1) 第一种域
	 *  Seconds Minutes Hours DayOfMonth Month DayOfWeek Year
	 * 
	 * 2) 第二种域 (没有 Year)
	 * Seconds Minutes Hours DayOfMonth Month DayOfWeek
	 * 
	 * 每个域可出现的字符如下:
	 * Seconds: 可出现 , - * / 4个字符，范围: [0, 59]
	 * Minutes: 可出现 , - * / 4个字符，范围: [0, 59]
	 * Hours: 可出现 , - * / 4个字符，范围: [0, 23]
	 * DayofMonth: 可出现 , - * / ? L W C 8个字符，范围: [0, 31]
	 * Month: 可出现 , - * / 4个字符，范围: [1, 12] 或 英文[JAN, DEC]
	 * DayOfWeek: 可出现 , - * / ? L C # 8个字符，范围: [1, 7] 或 英文[SUN, SAT]  1表示星期天，2表示星期一， 依次类推 
	 * Year: 可出现 , - * / 4个字符，范围: [1970, 2099]
	 * 
	 *  *(星号) 表示匹配该域的任意值，例如 Minutes域使用* 即表示每分钟都会触发事件.
	 *  
	 *  ?(问号) 只能用在DayOfMonth和DayOfWeek 两个域，也能匹配任意值，但实际不会，因为DayOfMonth和DayOfWeek
	 *  会相互影响，有一个使用星号时，另一个只能用问号，而不能用*.
	 *  
	 *  -(横杆) 表示范围，例如在Minutes使用20-50 则表示5-20分钟期间每分钟触发一次
	 *  
	 * /(斜杠) 表示从起始时间开始触发，然后每隔固定时间触发一次，例如Minutes域使用 5/20 则表示从第5分钟开始，
	 * 每隔20分钟触发一次，25, 45等分钟分别触发一次
	 * 
	 * ,(逗号) 表示列出枚举值，例如 Minutes使用 5,20则表示第5和第20分钟触发一次.
	 * 
	 * L 表示最后(last),只能出现在DayOfMonth 和 DayOfWeek域，例如在DayOfWeek使用 5L 则表示在最后一个星期4触发.
	 * L用在DayOfMonth表示一个月的最后一天，L用在DayOfWeek表示一个星期最后一天即星期六(7).
	 * 
	 * W 表示有效工作日(work 周一 到 周五)，只能出现在DayOfMonth域，系统将在离指定日期最近的有效工作日触发事件.
	 * 例如 DayOfMonth 使用5W，则表示 如果5日是星期六，则将在最近的工作日 星期五即 4日触发，若是星期天则在 6周一
	 * 触发. W最近寻找不会跨过月份.
	 * 
	 * LW 2个字符连用，即表示某个月最后一个工作日，用在DayOfMonth DayOfWeek
	 * 
	 *  #(井号) 只能用在DayOfMonth域，表示某个月的第几个星期几，例如 4#2 表示某月的第二(2)个星期三(4)
	 * 
	 * 
	 * 
	 */
	
	/**
	 * DayOfMonth 和 DayOfWeek
	 * 如果有一个指定的具体的日期，则另外一个必须使用问号，不然就会冲突.
	 * 不允许两个域同时使用星号.
	 */
	
}
