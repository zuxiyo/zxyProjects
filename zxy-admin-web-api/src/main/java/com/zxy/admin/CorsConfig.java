/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年12月8日 下午4:20:37
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年12月8日 下午4:20:37
 */
package com.zxy.admin;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 解决前端站点(主要为JavaScript发起的Ajax请求)访问的跨域问题
 * @author ZhuXY 
 * @date 2016年12月8日 下午4:20:37 
 */
@Configuration
public class CorsConfig extends WebMvcConfigurerAdapter {  
  
    @Override  
    public void addCorsMappings(CorsRegistry registry) {  
    	
    	registry.addMapping("/**")  
                .allowedOrigins("*")    //允许所有前端站点调用
                .allowCredentials(true)  
                .allowedMethods("GET", "POST", "DELETE", "PUT")  
                .maxAge(1728000);  
    }  
}
