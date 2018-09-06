package com.liugd.es.esdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import com.liugd.es.esdemo.kafka.producer.KafkaSender;

@SpringBootApplication
@EnableKafka
@EnableScheduling
@ServletComponentScan // 注意要加上@ServletComponentScan注解，否则Servlet无法生效
@EnableRedisHttpSession
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
