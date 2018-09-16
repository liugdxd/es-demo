package com.liugd.es.esdemo.support.demo;

import org.springframework.core.Ordered;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTest implements ITest,Ordered {

	@Override
	public void test(Object obj) {
		Test test = obj.getClass().getAnnotation(Test.class);
		log.debug("the test is {}",test.value());	
	}

}
