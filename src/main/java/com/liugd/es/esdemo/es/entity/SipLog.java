package com.liugd.es.esdemo.es.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import lombok.Getter;
import lombok.Setter;

@Document(indexName = "nginx-access-log-2018.09.12",type = "doc")
@Getter
@Setter
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

	@Override
	public String toString() {
		return "SipLog [id=" + id + ", referer=" + referer + ", remoteAddr=" + remoteAddr + ", request=" + request
				+ ", agent=" + agent + ", x_forwarded=" + x_forwarded + ", message=" + message + ", type=" + type + "]";
	}
	
}
