package com.liugd.es.esdemo.es.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.liugd.es.esdemo.es.dao.LogDao;
import com.liugd.es.esdemo.es.entity.SipLog;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/es")
@Slf4j
public class ElasticSearchController{
	@Autowired
	private LogDao logDao;

	@Autowired
	private ElasticsearchTemplate template;

	@GetMapping("/queryLog")
	public Optional<SipLog> queryLog(@RequestParam String id){
		log.info("id:"+id);
		return logDao.findById(id);
	}

	@PostMapping("/insertLog")
	public SipLog insertLog(@RequestBody SipLog sipLog){
		log.info(sipLog.toString());
		return logDao.save(sipLog);
	}

	@DeleteMapping("/delLog")
	public void delLog(@RequestParam String id){
		logDao.deleteById(id);
	}

	@GetMapping("/getAgent")
	public AggregatedPage<SipLog> queryLogHighLight(@RequestParam String message){
		log.info("message:"+message);
		String preTag = "<font color='#dd4b39'>";//google的色值
		String postTag = "</font>";

		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(QueryBuilders.termQuery("message", message))
				.withHighlightFields(new HighlightBuilder.Field("message").preTags(preTag).postTags(postTag))
				.build();


		return template.queryForPage(searchQuery,SipLog.class,new SearchResultMapper(){

			@SuppressWarnings("unchecked")
			@Override
			public <T> AggregatedPage<T> mapResults(SearchResponse response, Class<T> clazz, Pageable pageable) {
				
				List<SipLog> sipLogList = new ArrayList<>();
				 for (SearchHit searchHit : response.getHits()) {
					 if (response.getHits().getHits().length <= 0) {
	                        return null;
	                    }
					 String json = searchHit.getSourceAsString();
					 SipLog  sipLog = JSON.parseObject(json, SipLog.class);
					 sipLog.setId(searchHit.getId());
					 HighlightField message = searchHit.getHighlightFields().get("message");
					 if(message != null){
						 sipLog.setMessage(message.fragments()[0].string()); 
					 }
					 sipLogList.add(sipLog); 
				 }
				 if (sipLogList.size() > 0) {
	                    return new AggregatedPageImpl<T>((List<T>) sipLogList);
	                }
				
				return null;
			}
			
		});
	}
}
