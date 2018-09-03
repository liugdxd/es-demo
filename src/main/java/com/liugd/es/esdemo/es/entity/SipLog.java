package com.liugd.es.esdemo.es.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

@Document(indexName = "nginx-access-log-2018.08.28",type = "doc", shards = 5,replicas = 1, refreshInterval = "-1")
public class SipLog {
	@Id
	private String id;
	@Field
	private String referer;
	
	@Field
	private String remoteAddr;
	
	@Field
	private String request;
	
	@Field
	private String agent;
	
	@Field
	private String x_forwarded;
	
	@Field
	private String message;
	
	@Field
	private String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReferer() {
		return referer;
	}

	public void setReferer(String referer) {
		this.referer = referer;
	}

	public String getRemoteAddr() {
		return remoteAddr;
	}

	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getX_forwarded() {
		return x_forwarded;
	}

	public void setX_forwarded(String x_forwarded) {
		this.x_forwarded = x_forwarded;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
