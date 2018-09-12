package com.liugd.es.esdemo.config.esconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories("com.liugd.es.esdemo.es")
public class EsConfig {

}
