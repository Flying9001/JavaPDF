
package com.ljq.utils;

import freemarker.template.Configuration;

/** 
 * @author lujunqiang 
 * Date: 2017年8月14日 上午11:11:45 
 *
 */
public class FreemarkerBase {

	private Configuration freemarker_cfg = null;
	
	// 获取 freemarker 配置,freemarker 本身支持 classpath,目录和从 ServletContext 获取
	  protected Configuration getFreeMarkerCFG(){
	        if (null == freemarker_cfg){
	            freemarker_cfg = new Configuration();
	            freemarker_cfg.setDefaultEncoding("utf-8");
	            //ftl是放在classpath下的一个目录
	            freemarker_cfg.setClassForTemplateLoading(this.getClass(), "/freemarker/");
	        }
	        return freemarker_cfg;
	  }
	
	
	  
	  
	  
	  
	
}
