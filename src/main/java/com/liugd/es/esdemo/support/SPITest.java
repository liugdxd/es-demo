package com.liugd.es.esdemo.support;

import java.util.Set;

import com.alibaba.fastjson.util.ServiceLoader;
import com.liugd.es.esdemo.support.demo.ITest;

public class SPITest {
	public static void main(String[] args) {
		Set<ITest> load = ServiceLoader.load(ITest.class, Thread.currentThread().getContextClassLoader());
		for(ITest test : load){
			test.test(test);
		}
	}
}
