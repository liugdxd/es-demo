package com.liugd.es.esdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.liugd.es.esdemo.kafka.producer.KafkaSender;

@SpringBootApplication
@EnableKafka
@EnableScheduling
public class EsDemoApplication {
	
	@Autowired
	private KafkaSender kafkaSender;
	
	public static void main(String[] args) {
		SpringApplication.run(EsDemoApplication.class, args);
	}
	
	 //然后每隔1分钟执行一次
    @Scheduled(fixedRate = 1000)
    public void testKafka() throws Exception {
        kafkaSender.sendTest();
    }
}
