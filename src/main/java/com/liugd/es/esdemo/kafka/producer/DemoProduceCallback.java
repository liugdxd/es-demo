package com.liugd.es.esdemo.kafka.producer;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.RecordMetadata;

/**
 * 
 * @ClassName:：DemoProduceCallback 
 * @Description： 卡夫卡生产回调函数，解决kafka生产消息性能问题，例如：
 * 				kafka生产者生产一个消息和kafka集群交互来回需要1ms，如果
 * 				通过异步的方式则需要0.5ms，且返回结果通过回调函数的方式来完成
 * @author ：liugd
 * @date ：2018年8月31日 下午4:39:15 
 *
 */
public class DemoProduceCallback implements Callback{
	
	@Override
	public void onCompletion(RecordMetadata metadata, Exception exception) {
		if (exception != null) {
			exception.printStackTrace();
		} 
		
	}
	
	
	

}
