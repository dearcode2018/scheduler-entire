/**
  * @filename SchedulerConfiguration.java
  * @description 
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

import com.github.ltsopensource.spring.boot.annotation.EnableTaskTracker;

/**
 * @type SchedulerConfiguration
 * @description 
 * @author qianye.zheng
 */
// 控制定时任务是否开启
@ConditionalOnProperty(name = {"scheduler.lts.switch"}, havingValue = "true")
@EnableTaskTracker
@Configuration
public class SchedulerConfiguration {

}
