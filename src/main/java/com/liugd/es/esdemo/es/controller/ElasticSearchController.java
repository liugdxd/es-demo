package com.liugd.es.esdemo.es.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.liugd.es.esdemo.es.dao.LogDao;
import com.liugd.es.esdemo.es.entity.SipLog;

@RestController
@RequestMapping("/es")
public class ElasticSearchController {
	Logger log = LoggerFactory.getLogger(getClass());
	@Autowired
	private LogDao logDao; 
	
	@GetMapping("/queryLog")
	public Optional<SipLog> queryLog(@RequestParam String id){
		log.info("id:"+id);
		return logDao.findById(id);
	}
	
	@PostMapping("/insertLog")
	public SipLog insertLog(SipLog sipLog){
		
		return logDao.save(sipLog);
	}
	
	@DeleteMapping("/delLog")
	public void delLog(@RequestParam String id){
		logDao.deleteById(id);
	}
}
