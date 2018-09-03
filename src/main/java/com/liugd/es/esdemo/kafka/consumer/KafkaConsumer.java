package com.liugd.es.esdemo.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
@Component
public class KafkaConsumer {

	Logger log = LoggerFactory.getLogger(getClass());
    /**
     * 监听test主题,有消息就读取
     * @param message
     */
    @KafkaListener(topics = {"test"})
    @Profile(value="devAh")
    public void consumer(String message){
        log.info("test topic message : {}", message);
    }
    
    @Profile(value="devBj")
    public void consumerBj(String message){
        log.info("test topic message : {}", message);
    }
    
    
}
