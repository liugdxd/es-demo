package com.liugd.es.esdemo.es.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import com.liugd.es.esdemo.es.entity.SipLog;

@Component
public interface LogDao extends ElasticsearchRepository<SipLog, String>{

}
