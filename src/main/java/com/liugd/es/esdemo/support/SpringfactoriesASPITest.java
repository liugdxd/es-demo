package com.liugd.es.esdemo.support;

import java.util.List;

import org.springframework.core.io.support.SpringFactoriesLoader;

import com.liugd.es.esdemo.support.demo.ITest;

public class SpringfactoriesASPITest {

	public static void main(String[] args){
		List<String> loadFactories = SpringFactoriesLoader.loadFactoryNames(ITest.class,Thread.currentThread().getContextClassLoader());
		for(String test: loadFactories){
			System.out.println(test);
		}
		
	}
}
