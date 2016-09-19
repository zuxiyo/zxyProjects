package com.zxy.admin.controllers;

import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
  
import java.util.Map;  

/**
 * 
 * @author zuxiy
 */
@Controller  
public class IndexController {  
 
	/**
	 * 
	 * @param model
	 * @return
	 */
    @RequestMapping("/")  
    public String web(Map<String,Object> model){  
 
        return "_layouts/index";
    }  
}