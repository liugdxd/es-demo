package com.liugd.es.esdemo.config.concurrent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

/**
 * 并发控制
* @ClassName:：ConcurrentConfig 
* @Description： TODO
* @author ：liugd
* @date ：2018年9月6日 下午8:24:41 
*
 */
@Configuration
public class ConcurrentConfig {
	
	@Bean
	public SimpleAsyncTaskExecutor simpleAsyncTaskExecutor(){
		SimpleAsyncTaskExecutor executor = new SimpleAsyncTaskExecutor();
		executor.setDaemon(true);
		executor.setConcurrencyLimit(10);
		executor.setThreadNamePrefix("simpleAsyncTaskExecutor");
		return executor;
		
	}
	
}
