package com.zxy.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 部门管理控制器
 * @author Zhu XiYong
 *
 */
@Controller
@RequestMapping("/depts")
public class DeptsController {

	/**
	 * 部门管理主页
	 * @return 
	 */
	@RequestMapping("/index")
	public String index(){
		return "depts/deptIndex";
	}
}
