package com.liugd.es.esdemo.config.db;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

import com.alibaba.druid.support.http.WebStatFilter;
/**
 * 
* @ClassName:：DruidStatFilter 
* @Description： TODO
* @author ：liugd
* @date ：2018年9月6日 下午6:37:19 
*
 */

@WebFilter(filterName="druidWebStatFilter",  
urlPatterns="/*",  
initParams={  
    @WebInitParam(name="exclusions",value="*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*"),// 忽略资源  
}) 
public class DruidStatFilter extends WebStatFilter {

}
