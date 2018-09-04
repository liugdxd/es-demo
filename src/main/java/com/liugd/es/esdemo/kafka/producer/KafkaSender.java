package com.liugd.es.esdemo.kafka.producer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class KafkaSender{

	Logger log = LoggerFactory.getLogger(getClass());
	
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    /**
     * 发送消息到kafka,主题为test
     */
    public void sendTest(){
    	log.info("消息发送");
        ListenableFuture<SendResult<String,String>> send = kafkaTemplate.send("test","test","hello,kafka  "  + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
        send.addCallback(new DemoProduceCallback());
    }
}
