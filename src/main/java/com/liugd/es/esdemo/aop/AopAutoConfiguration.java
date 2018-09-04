package com.liugd.es.esdemo.aop;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liugd
 * @create 2018/5/14
 * @since 3.0
 */


@Configuration
public class AopAutoConfiguration {

 /*   @Bean(name = "txManager")
    public DataSourceTransactionManager getTx(DataSource dataSource) {

        DataSourceTransactionManager dsTx = new DataSourceTransactionManager(dataSource);
        return dsTx;
    }
    
    @Bean(name = "txAdvice")
    @ConditionalOnBean(name = {"txManager"})
    public DefaultTransactionInterceptor getAdvisor(@Qualifier("txManager") DataSourceTransactionManager txManager)
            throws Exception {
        DefaultTransactionInterceptor tsi = new DefaultTransactionInterceptor();
        Properties properties = new Properties();
        properties.setProperty("*", "PROPAGATION_REQUIRED,-Exception");
        properties.setProperty("*Tns", "PROPAGATION_NESTED,-Exception");
        properties.setProperty("*Tne", "PROPAGATION_REQUIRES_NEW,-Exception");


        tsi.setTransactionAttributes(properties);
        tsi.setTransactionManager(txManager);


        return tsi;
    }*/
	
	
	
	@Bean
    public BeanNameAutoProxyCreator txProxy() {
        BeanNameAutoProxyCreator creator = new BeanNameAutoProxyCreator();

//        creator.setInterceptorNames(getTargetAopNames());


        creator.setBeanNames("*Svc");
        creator.setProxyTargetClass(true);
        return creator;
    }
   


}
