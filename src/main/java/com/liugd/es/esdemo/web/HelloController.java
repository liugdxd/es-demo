package com.liugd.es.esdemo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	Logger log = LoggerFactory.getLogger(getClass());
	@RequestMapping(value="/session")
	public SessionInfo getSession(HttpServletRequest req){
		SessionInfo sessionInfo = new SessionInfo();
		HttpSession session = req.getSession();
		sessionInfo.setCreateTime(session.getCreationTime());
		sessionInfo.setId(session.getId());
		sessionInfo.setLastAccessTime(session.getLastAccessedTime());
		sessionInfo.setNew(session.isNew());
		return sessionInfo;
	}
}
