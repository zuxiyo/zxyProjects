/*
 * Created by Zhu XiYong <zuxiyo@sohu.com> at 2016年9月22日下午4:27:52
 * 
 * 作        者：Zhu XiYong(zuxiyo@sohu.com)
 * 创建时间： 2016年9月22日下午4:27:52
 */
package com.zxy.admin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 
 * @author Zhu XiYong 
 * @Date 2016年9月22日下午4:27:52
 */
@Controller
@RequestMapping(value="test")
public class TestController {

	/**
	 * 对话框测试，遮盖效果老是不行
	 * @return
	 */
	@RequestMapping(value="dialog")
	public String dialog(){
		return "test/dialog";
	}
}
